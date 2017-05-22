package LeetCode;

public class HouseRobber2 {
	public int rob(int[] nums) {
		int n = nums.length;
        if(n == 0) return 0;
        if(n ==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[n-1];
        dp[0] = nums[0];
//        dp[1] = 0;
        dp[1] =  Math.max(nums[0], nums[1]);
        int max= dp[1];
        for(int i = 2; i<n-1;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        dp[0]=nums[1];
        dp[1]=Math.max(dp[0], nums[2]);
        int max2=dp[1];
        for(int j = 3; j<n;j++){
            dp[j-1] = Math.max(dp[j-3]+nums[j], dp[j-2]);
            max2 = Math.max(max2, dp[j-1]);
        }
        return max>max2 ? max:max2;
        }
}
