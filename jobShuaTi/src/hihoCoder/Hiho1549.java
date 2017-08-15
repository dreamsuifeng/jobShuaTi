package hihoCoder;

import java.math.BigInteger;
import java.util.Scanner;

public class Hiho1549 {
	private static void printThreeMatrix(long[][][] dp){
		int i=0,j=0,l=0;
		for (long[][] m: dp){
			for (long[] n:m){
				for (long k:n){
					System.out.println(i+","+j+","+l+":"+k);
					l=(1+l)%(dp[0][0].length);
				}
				j=(1+j)%dp[0].length;
			}
			i++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long mod=1000000007;
			int T=in.nextInt();
			while (T>0){
				int N=in.nextInt();
				int K=in.nextInt();
				long[] d=new long[N];
				for (int i=0;i<N;++i){
					d[i]=in.nextLong();
				}
				long[][][] dp=new long[N][N+1][K+1];
				for (int r=0;r<N;++r){
					if (r==0 && d[0]<=N){
						dp[r][(int) d[0]][1]=1;
						continue;
					}
					for (int c=0;c<=N;++c){
						
						for (int l=1;l<=K;++l){
							dp[r][c][l]=dp[r-1][c][l];
							if (l==1 && d[r]<=N && c==d[r]){
								dp[r][c][l]=(dp[r][c][l]+1)%mod;
								continue;
							}
							if (l==1) continue;
							
							for (int ll=c;ll>=0;--ll){
								if ((ll|d[r])==c){
									dp[r][c][l]=(dp[r][c][l]+dp[r-1][ll][l-1])%mod;
								}
							}
						}
					}
				}
				printThreeMatrix(dp);
				long ans=0;
				for (int id=1;id<=N;++id){
					ans=(ans+id*dp[N-1][id][K])%mod;
				}
				System.out.println(ans);
				T--;
			}
			
	}

}
