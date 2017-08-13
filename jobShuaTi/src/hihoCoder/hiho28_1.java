package hihoCoder;

import java.util.Scanner;

public class hiho28_1 {
	public static int solve(int[] d,int n){
		int one=0;
		int two=0;
		int ans=0;
		for (int i=0;i<n;++i){
			if (d[i]==1){
				one++;
			}else if (d[i]==2){
				two+=one;
			}else{
				ans+=two;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] data=new int[n];
		for (int i=0;i<n;++i){
			data[i]=in.nextInt();
			
		}
		System.out.println(solve(data, n));
//		int[][][] dp=new int[n][4][4];
//		dp[0][data[0]][1]=1;
//		for (int i=1;i<n;++i){
//			for (int j=1;j<4;++j){
//				for (int k=1;k<4;++k){
//					if (k==1){
//						if (j==data[i]){
//							dp[i][j][k]=1+dp[i-1][j][k];
//							
//						}else{
//							dp[i][j][k]=dp[i-1][j][k];
//						}
////						System.out.println(i+","+j+","+k+":"+dp[i][j][k]);
//						continue;
//					}
//					dp[i][j][k]=dp[i-1][j][k];
//					if (j!=data[i]) continue;
//					for (int l=data[i]-1;l>=1;l--){
//						dp[i][data[i]][k]+=dp[i-1][l][k-1];
//					}
////					System.out.println(i+","+j+","+k+":"+dp[i][j][k]);
//				}
//			}
//		}
//		System.out.println(dp[n-1][1][3]+dp[n-1][2][3]+dp[n-1][3][3]);
	}

}
