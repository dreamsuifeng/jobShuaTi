package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayLargestSum410 {
	
	public int splitArray1(int[] nums, int m) {
		int n=nums.length;
		int[][] dp=new int[n][m];
		dp[0][0]=nums[0];
		for(int i=1;i<n;i++){
			dp[i][0]=dp[i-1][0]+nums[i];
			for(int k=1;k<m;k++){
			        dp[i][k]=Integer.MAX_VALUE;
			        for(int j=i-1;j>=0&&k-1<=j;j--){
				        dp[i][k]=Math.min(dp[i][k], Math.max(dp[j][k-1],dp[i][0]-dp[j][0]));
				        if(dp[i][0]-dp[j][0]>=dp[i][k]){
					        break;
				        }
			        }
		        }
	        }
	        return dp[n-1][m-1];
	    }
	public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, sum, max);
    }
    
    private long binary(int[] nums, int m, long high, long low){
        long mid = 0;
        while(low < high){
            mid = (high + low)/2;
            if(valid(nums, m, mid)){
                //System.out.println(mid);
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
    
    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
	}

}
