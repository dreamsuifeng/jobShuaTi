package hihoCoder;

import java.util.Arrays;
import java.util.Scanner;

public class hiho23_3 {
	static long mod=(long) (1e9+7);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print(mod);
		Scanner in=new Scanner(System.in);
		
			long N=in.nextLong();
			long K=in.nextLong();
			long[] dp=new long[10];
			long[] dppre=new long[10];
			for (long i=0;i<N;++i){
				Arrays.fill(dp, 0);
				for (int j=(int) Math.min(K,9);j>=0;--j){
					if (j==0 && i==0){
						continue;
					}
					if (i==0){
						dp[j]=1;
//						dppre[j]=1;
					}else {
						for (int l=0;l<=Math.min(K,9);++l){
							if (l*j<=K){
								dp[j]=(dp[j]+dppre[l])%mod;
							}
						}
					}
				}
				dppre=Arrays.copyOf(dp, (int) (K+1));
			}
			long ans=0;
			for (int i=0;i<=9;++i){
				ans=(ans+dp[i])%mod;
			}
			System.out.println(ans);
		
	}

}
