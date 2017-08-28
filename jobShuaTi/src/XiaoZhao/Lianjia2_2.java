package XiaoZhao;

import java.util.*;
public class Lianjia2_2 {
	
	public static long solve(long[] d,int n,int m,int k,long min){
		long[][] dp=new long[n][m+1];
		
		for (int i=0;i<n;++i){
			for (int j=0;j<=m;++j){
				dp[i][j]=min;
				if (j==0) continue;
				if (i==0){
					dp[i][1]=d[0];
					continue;
				}
				if (j==1){
					dp[i][j]=Math.max(dp[i-1][j], d[i]);
					continue;
				}
				if(i-k>=0){
					dp[i][j]=Math.max(dp[i-1][j], d[i]+dp[i-k][j-1]);
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n-1][m];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int k=in.nextInt();
		long[] d=new long[n];
		long min=Long.MAX_VALUE;
		for (int i=0;i<n;++i){
			d[i]=in.nextLong();
			min=Math.min(min, d[i]);
		}
		System.out.println(solve(d, n, m, k,min));
	}

}
