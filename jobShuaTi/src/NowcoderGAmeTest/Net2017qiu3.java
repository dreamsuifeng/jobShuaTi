package NowcoderGAmeTest;

import java.util.Arrays;
import java.util.Scanner;

public class Net2017qiu3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		long[] dp=new long[M-N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for (int i=N;i<=M;++i){
			for (int j=2;j<=Math.sqrt(i);++j){
				if (i%j==0 && i+j<=M){
					dp[i+j-N]=Math.min(dp[i+j-N], dp[i-N]+1);
				}
				if (i%j==0 && i+i/j<=M){
					dp[i+i/j-N]=Math.min(dp[i+i/j-N], dp[i-N]+1);
				}
			}
		}
		System.out.println(dp[M-N]>(M-N) ? -1:dp[M-N]);
	}

}
