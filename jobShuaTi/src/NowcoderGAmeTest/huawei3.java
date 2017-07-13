package NowcoderGAmeTest;

import java.util.Scanner;

import javax.jws.Oneway;

public class huawei3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int M=in.nextInt();
		int N=in.nextInt();
		int[][] data=new int[M][N];
		for (int i=0;i<M;++i){
			for (int j=0;j<N;++j){
				data[i][j]=in.nextInt();
			}
		}
		int[][] dp=new int[M][N];
		dp[0][0]=data[0][0];
		for (int i=1;i<N;++i){
			dp[0][i]=dp[0][i-1]+data[0][i];
		}
		for (int i=1;i<M;++i){
			dp[i][0]=dp[i-1][0]+data[i][0];
		}
		for (int i=1;i<M;++i){
			for (int j=1;j<N;++j){
				dp[i][j]=Math.max(dp[i-1][j]+data[i][j], dp[i][j-1]+data[i][j]);
			}
		}
		System.out.println(dp[M-1][N-1]);
	}

}
