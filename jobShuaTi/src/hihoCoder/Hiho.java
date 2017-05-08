package hihoCoder;
import java.util.Scanner;
import java.util.Arrays;
public class Hiho {
	static int findP(int[] nums,int i,int j,int target,int count,int s,int e){
		if (i+1==j){
			if (nums[i]+nums[j]==target){
				return 1;
			}else {
				return 0;
			}
		}
		while(i<j){
//			if (i==s || i==e){
//				i+=1;
//			}
//			if (j==s || j==e) {
//				j-=1;
//			}
			int temp=nums[i]+nums[j];
			if (temp==target){
				return 1+findP(nums, i+1, j-1, target,count, s, e);
			}else if (temp>target){
				j-=1;
			}else if (temp<target){
				i+=1;
			}
		}
		return count;
	}
//	static int isTure(int[] nums,int target,int s, int e){
//		int result=0;
//		int i=0;
//		int j=nums.length-1;
//		while(i<j){
//				result+=;
//			}
//		}
//		
//		return result;
//	}
	static int computeNKinds(int N,int[] nums){
		Arrays.sort(nums);
		int result=0;
		for (int i=0;i<N-1;++i){
			for (int j=i+1;j<N;++j){
				int r=findP(nums, 0, nums.length-1, nums[i]+nums[j], 0,i,j);
//				if (r>0) {
					result+=r-1;
					
//				}
					
			}
		}
		return result;
	}
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner inScanner =new Scanner(System.in);
		while (inScanner.hasNext()) {
			int N=inScanner.nextInt();
			int i=0;
			int[] coins=new int[N];
			while(i<N){
				coins[i]=inScanner.nextInt();
				i++;
			}
			System.out.println(computeNKinds(N, coins));
			
			
		}
	}
}
