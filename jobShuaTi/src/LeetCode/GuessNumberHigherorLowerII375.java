package LeetCode;

public class GuessNumberHigherorLowerII375 {
	public int getMoneyAmount(int n) {
        if(n==1 || n==2) return n-1;
        int[][] dp=new int[n+1][n+1];
        for (int len=1;len<n;len++){
        	for (int i=1;i+len<=n;++i){
        		int j=i+len;
        		dp[i][j]=Integer.MAX_VALUE;
        		for (int k=i;k<=j;++k){
        			dp[i][j]=Math.min(dp[i][j], 
        					k+Math.max(k-1>=i ? dp[i][k-1]:0,j>=k+1?dp[k+1][j]:0));
        		}
        	}
        }
        return dp[1][n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
