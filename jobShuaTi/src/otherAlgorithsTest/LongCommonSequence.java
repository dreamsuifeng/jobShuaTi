package otherAlgorithsTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.EnumSet;
public class LongCommonSequence {
	private int[][] dp;
	public LinkedList<String> res=new LinkedList<>();

	public int longSequence(String s, String p) {
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

	public void printString(String temp, int i, int j, String s, String p) {
		while (i > 0 && j > 0) {
			if (s.charAt(i - 1) == p.charAt(j - 1)) {
				temp = s.charAt(i - 1) + temp;
				--j;
				--i; 
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					--i;
				} else if (dp[i - 1][j] <= dp[i][j - 1]) {
					--j;
				}

			}
		}
//		System.out.println(temp);
		res.add(temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongCommonSequence tCom = new LongCommonSequence();
		System.out.println(tCom.longSequence("abcd", "abdca"));
		// List<String> res=new LinkedList<>();
		String s = "";
		tCom.printString(s, tCom.dp.length - 1, tCom.dp[0].length - 1, "abcd", "abcdca");
		System.out.println(tCom.res);
	}

}
