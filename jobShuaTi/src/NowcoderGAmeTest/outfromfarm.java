package NowcoderGAmeTest;

import java.util.Scanner;

public class outfromfarm {
	public static int solve(int n, int k){
		int[][][] dp=new int[n+1][k+1][n];
		for (int i=1;i<=n;++i){
			for (int j=1;j<=(int)Math.min(k, i);++j){
				for (int l=0;l<n;++l){
					if (i==1 && l==0){
						dp[i][j][l]=1;
					}else{
						int t2=dp[i-1][j-1][l];
						if (j-1==0 && l==0){
							t2=1;
						}
						int index=(l+i-1)%n;
						dp[i][j][index]+=(t2+dp[i-1][j][index])%1000000007;
					}
				}
			}
		}
		return dp[n][k][0];
	}
	public static int solve1(int n, int k){
		int[][] dp=new int[k+1][n];
		dp[0][0]=1;
		for (int i=1;i<=n;++i){
			
			for (int j=k;j>=1;--j){
				for (int l=0;l<n;++l){
						dp[j][l]=(dp[j][l]+dp[j-1][(l-i+1+n)%n])%1000000007;
				
				}	
			}
		}
		return dp[k][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		System.out.println(solve1(n,k));
	}

}
