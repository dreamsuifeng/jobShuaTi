package templates;

public class bitDp {
	int len;
	int digit;
	int[][] dp=new int[len][digit];
	private int dfs(int len, int dig, boolean end_falg){
		int ILLEGAL, LEGAL;
		if (len<0){
			return ILLEGAL;
		}
		if (!end_falg && dp[len][dig]!=-1){
			return dp[len][dig];
		}
		if (len==1){
			return (Q ? LEGAL:ILLEGAL);
		}
		int end=end_falg?bits[len-2]:9;
		int ans=0;
		for(int j=0;j<end+1;++j){
			ans+=dfs(len-1, j, end_falg&&(j==end));
		}
		if (!end_falg) dp[len][dig]=ans;
		return ans;
	}
	int solve(int n){
		if (n<=0) return 0;
		int l=0;
		
	}
}
