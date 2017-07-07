package NowcoderGAmeTest;
import java.util.*;

import LeetCode.sumRoottoLeafNumbers;
public class doublekeralprocess {
	public static int solve(int[] array,int sum,int n){
		
		int[][] f = new int[n + 1][sum / 2 + 1];  
        for (int i = 0; i < n; i++) {  
            for (int j = 1; j <= sum / 2; j++) {  
                f[i + 1][j] = f[i][j];  
                if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {  
                    f[i + 1][j] = f[i][j - array[i]] + array[i];  
                }  
            }  
        }
		return sum-f[n][sum/2];
	}
	public static int canPartition(int[] nums) {
		int res=0;
		int sum=0;
        for (int i:nums){
        	sum+=i;
        }
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> newque=new LinkedList<>();
        boolean[][] dp=new boolean[nums.length][sum/2+1];
        if (nums[0]<=sum/2) {
        	q.add(nums[0]);
        	res=Math.max(res,nums[0]);
        }
        if (nums[0]>=sum/2) return nums[0];
        for (int i=1;i<nums.length;++i){
        	
        	if (nums[i]<=sum/2){
        		newque.add(nums[i]);
        		res=Math.max(res,nums[i]);
        	}
        	if (nums[i]>=sum/2) return nums[i];
        	while(!q.isEmpty()){
        		int preSum=q.poll();
                newque.add(preSum);
        		if( preSum+nums[i]<=sum/2){        			
        			newque.add(preSum+nums[i]);
        			res=Math.max(res,preSum+nums[i]);
                    
        		}
        	}
        	q.addAll(newque);
        	newque.clear();
        	
        }
        return sum-res;
    }
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] d=new int[n];
        int sum=0;
        for (int i=0;i<n;++i){
        	int t=in.nextInt()/1024;
        	sum+=t;
        	d[i]=t;
        }
        
//        Arrays.sort(d,new Comparator<Integer>(){
//        
//
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			// TODO Auto-generated method stub
//			return o2-o1;
//		}});
//        Collections.sort(l,(x,y)->(y-x));
        System.out.println(solve(d, sum, n)*1024);
        
        	
        
        
    }

}
