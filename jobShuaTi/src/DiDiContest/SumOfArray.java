package DiDiContest;

import java.util.*;

public class SumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int sum=in.nextInt();
		long[] d=new long[n];
		int sumAll=0;
		for (int i=0;i<n;++i){
			d[i]=in.nextLong();
		}
		long[][] dp=new long[n][sum+1];
		if (d[0]<=sum){
			dp[0][(int) d[0]]=1;
			
		}
		dp[0][0]=1;
		for (int i=1;i<n;++i){
			for (int j=0;j<=sum;++j){
				if (j-d[i]>=0)
					dp[i][j]+=(dp[i-1][(int) (j-d[i])]+dp[i-1][j]);
				else
					dp[i][j]+=dp[i-1][j];
			}
		}
		
		System.out.println(dp[n-1][sum]);
	}

}
