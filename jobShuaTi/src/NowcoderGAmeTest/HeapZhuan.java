package NowcoderGAmeTest;


import java.util.Scanner;

public class HeapZhuan {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] height=new int[n];
		int sum=0;
		for (int i=0;i<n;++i){
			height[i]=in.nextInt();
			sum+=height[i];
		}

		int[][] dp = new int[2][2*sum+1];
		for(int i=0; i<2*sum+1; i++){
			dp[0][i] = -1;
		}
		dp[0][sum] = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<2*sum+1; j++){
				dp[1][j] = dp[0][j];
				if(j-height[i]>=0 && dp[0][j-height[i]]!=-1){
					dp[1][j] = Math.max(dp[1][j], dp[0][j-height[i]]);
				}
				if(j+height[i]<=2*sum && dp[0][j+height[i]]!=-1){
					dp[1][j] = Math.max(dp[1][j], dp[0][j+height[i]]+height[i]);
				}
			}
			int[] temp = dp[0];
			dp[0] = dp[1];
			dp[1] = temp;
		}
		if(dp[0][sum] == 0)
			System.out.println(-1);
		else
			System.out.println(dp[0][sum]);
		
	}
}
