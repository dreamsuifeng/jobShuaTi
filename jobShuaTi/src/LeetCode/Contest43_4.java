package LeetCode;

public class Contest43_4 {
	 public int maxA(int N) {
		 int[] dp = new int[N+1];
	        dp[0] = 0;
	        for(int i = 0;i < N;i++){
	        	dp[i+1] = Math.max(dp[i+1], dp[i] + 1);
	        	for(int j = 1;i+2+j <= N;j++){
	        		dp[i+2+j] = Math.max(dp[i+2+j], dp[i] * (j+1));
	        	}
	        }
	        return dp[N];
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
