package hihoCoder;

import java.util.Scanner;

public class hiho162 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s=in.next();
		char[] sc=s.toCharArray();
		int[][] dp=new int[sc.length][sc.length];
		for (int i=sc.length-1;i>=0;i--){
			
			for (int j=i+1;j<sc.length;j++){
				if (sc[i]==sc[j]){
					dp[i][j]=dp[i+1][j-1];
				}else{
					int a=1+dp[i+1][j];
					int b=1+dp[i][j-1];
					int c=1+dp[i+1][j-1];
					dp[i][j]=Math.min(Math.min(a, b), c);
				}
			}
		}
		System.out.println(dp[0][sc.length-1]);
	}

}
