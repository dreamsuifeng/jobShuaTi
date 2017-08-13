package XiaoZhao;

import java.util.Scanner;

public class Wangyi_8 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		long mod=1000000007;
		int n=in.nextInt();
		int k=in.nextInt();
		long[][] dp=new long[n][k+1];
		for (int i=0;i<n;i++){
			long sum=0;
			if (i>0){
				for (int l=1;l<=k;++l){
					sum=(sum+dp[i-1][l])%mod;
				}
			}
			for (int j=1;j<=k;++j){
				if (i==0)
					dp[i][j]=1;
				else{
					
					long sumdiff=0;
					for (int l=j+j;l<=k;l=l+j){
						sumdiff=(sumdiff+dp[i-1][l])%mod;
					}
					dp[i][j]=(sum-sumdiff+mod)%mod;
				}
			}
		}
		long ans=0;
		for (int i=1;i<=k;++i){
			ans=(ans+dp[n-1][i])%mod;
		}
		System.out.println(ans);
	}
}
