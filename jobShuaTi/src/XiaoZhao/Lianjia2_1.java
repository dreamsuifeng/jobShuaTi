package XiaoZhao;


import java.util.Scanner;

public class Lianjia2_1 {
	
	public static int longSequence(String s, String p) {
		int[][] dp;
		int sn = s.length();
		int pn = p.length();
		dp = new int[sn + 1][pn + 1];
		for (int i = 0; i < sn + 1; ++i) {
			for (int j = 0; j < pn + 1; ++j) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int i=1;
//		getType()
		return dp[sn][pn];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		System.out.println(longSequence(s1, s2));
	}

}
