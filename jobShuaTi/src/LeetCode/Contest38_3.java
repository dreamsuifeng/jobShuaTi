package LeetCode;

public class Contest38_3 {
	int mo=1000000007;
	public int kInversePairs(int n, int k) {
        int[][] dp=new int[n+1][k+1];
        dp[1][0]=1;
        for (int i=2;i<n+1;++i){
        	dp[i][0]=1;
        	for (int j=1;j<k+1;++j){
        		dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mo;
        		if (j>=i) dp[i][j]=(dp[i][j]-dp[i-1][j-1]+mo)%mo;
        	}
        }
        return dp[n][k];
    }
}
