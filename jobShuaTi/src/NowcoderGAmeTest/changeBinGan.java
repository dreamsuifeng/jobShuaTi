package NowcoderGAmeTest;

import java.math.BigInteger;
import java.util.Scanner;

import sun.misc.FpUtils;

public class changeBinGan {
	private static int ans=0;
//	private static int step=0;
	public static void dfs(int i, char[] s, int n){
//		step++;
		if (i>=s.length){
			BigInteger tmp=new BigInteger(String.valueOf(s));
			if (tmp.remainder(new BigInteger(""+n)).equals(new BigInteger("0"))) ans++;
			return;
		}
		if (s[i]=='X'){
			for (int j=0;j<=9;j++){
				s[i]=(char) ('0'+j);
				dfs(i+1, s, n);
			}
			s[i]='X';
		}else{
			dfs(i+1, s, n);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		char[] s=in.next().toCharArray();
		int n=in.nextInt();
		long[][] dp=new long[s.length+1][n];
		
		dp[0][0]=1;
		for (int i=1;i<=s.length;i++){
			char c=s[i-1];
			for (int j=0;j<n;++j){
				for (int k=0;k<10;k++){
					if (c=='X' || c=='0'+k){
						dp[i][(j*10+k)%n]+=dp[i-1][j];
					}
				}
			}
		}
		System.out.println(dp[s.length][0]);
		
	}

}
