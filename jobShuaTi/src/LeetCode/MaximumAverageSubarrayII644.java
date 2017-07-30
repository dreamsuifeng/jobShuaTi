package LeetCode;

public class MaximumAverageSubarrayII644 {
	private static void print(int[][] a){
		for(int[] i:a){
			for (int j:i){
				System.out.print(j+",");
			}
			System.out.println();
		}
	}
	public static double findMaxAverage(int[] nums, int k) {
		int n=nums.length;
        double res=Integer.MIN_VALUE;
        int tmp=0;
        for (int i=0;i<n;++i){
        	tmp+=nums[i];
        	if (i>=k){
        		int s=0;
        		int t=tmp;
        		while (i-s+1>=k){
        			res=Math.max(res, t/(double)(i-s+1));
        			t-=nums[s];
        			s++;
        		}
        	}
        }
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(a, 4));
	}

}
