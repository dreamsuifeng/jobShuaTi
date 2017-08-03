package LeetCode;

public class targetSum {
	public int findTargetSumWays(int[] nums, int S) {
        int n=nums.length;
        int[][] dp=new int[n+1][2001];
        for (int i=1;i<=n;++i){
        	if (i==1){
    			dp[i][nums[i-1]+1000]=1;
    			dp[i][-nums[i-1]+1000]=1;
    			continue;
    		}
        	
        	for(int j=0;j<=2000;++j){
        		if (j-nums[i-1]>=0){
        			dp[i][j]+=dp[i-1][j-nums[i-1]];
        		}
        		if (j+nums[i-1]<2001){
        			dp[i][j]+=dp[i-1][j+nums[i-1]];
        		}
        		
        	}
        }
        return dp[n][S+1000];
    }
	public static void main(String[] args){
		
	}
}
