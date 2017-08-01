package hihoCoder;

import java.util.Scanner;

public class ABoxofCoins {
	void dfs(long[][] d,int i,int j,int val,int juli){
		
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		long N=in.nextLong();
		long[][] d=new long[2][(int) N];
		long sum=0;
		for (int i=0;i<N;++i){
			d[0][i]=in.nextLong();
			d[1][i]=in.nextLong();
			sum+=d[0][i]+d[1][i];
		}
		long val=sum/(2*N);
	}
}
