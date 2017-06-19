package NowcoderGAmeTest;

import java.util.Scanner;

public class outfromfarm {
	public static int solve(int n, int k){
		if (k==1) return 0;
		int[][][] dp=new int[n+1][k+1][n];
//		int index=((k-1)*k/2)%n;
//		int idk_1=((k-2)*(k-1)/2)%n;
		for (int i=1;i<=n;++i){
			for (int j=1;j<=Math.min(k, i);++j){
				for (int l=0;l<n;++l){
					if (i==1 && l==0){
						dp[i][j][l]=1;
					}
					int t2=dp[i-1][j-1][l];
					int index=(l+i-1)%n;
					dp[i][j][index]=t2+dp[i-1][j][index];
				}
			}
		}
		return dp[n][k][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		System.out.println(solve(n,k));
	}

}
