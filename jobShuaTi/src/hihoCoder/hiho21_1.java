package hihoCoder;

import java.util.Scanner;

public class hiho21_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		long k=in.nextLong();
		long mod=1000000007l;
		long[] d=new long[N];
		for (int i=0;i<N;++i){
			d[i]=in.nextLong();
		}
		long[][] dp=new long[N][N];
		for(int i=N-1;i>=0;--i){
			long max=d[i];
			long min=d[i];
			for (int j=i;j<N;++j){
				
			}
		}
		System.out.println(dp[N-1]);
	}
}
