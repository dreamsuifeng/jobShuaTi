package LeetCode;

public class PalindromicSubstrings647 {
	private static void print(int[][] a){
		for (int[] j:a){
			for(int i:j){
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
	public static int countSubstrings(String s) {
		int n=s.length();
		int[][] dp=new int[n][n];
		char[] sc=s.toCharArray();
		int res=0;
		for (int i=0;i<n;++i){
			dp[i][i]=1;
			res++;
			for (int j=i-1;j>=0;--j){
				if (sc[i]==sc[j] && ((i-j<3)||dp[i-1][j+1]==1)){
					dp[i][j]=1;
				}
				if (dp[i][j]==1) res++;
			}
	
		}
		
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstrings("aaa"));
	}

}
