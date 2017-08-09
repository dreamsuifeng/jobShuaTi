package LeetCode;

import java.util.Arrays;

public class CoinChange518 {
	 	public int change(int amount, int[] coins) {
	 		if (coins==null || coins.length==0 || amount==0) return 1;
	        int n=coins.length;
		        Arrays.sort(coins);
		        int c=amount/coins[0];
		        int[][] dp=new int[n][amount+1];
		        for (int i=0;i<n;i++){
	                dp[i][0]=1;
		        	for (int j=1;j<=amount;++j){
		        		if(i==0){
		        			dp[i][j]=(j%coins[i]==0 ? 1:0);
	                        continue;
		        		}
		        		for (int k=0;k<=amount/coins[i];++k){
		        			if(j-k*coins[i]>=0){
		        				dp[i][j]+=dp[i-1][j-k*coins[i]];
		        			}
		        		}
		        	}
		        }
		        // for (int[] i:dp){
		        // 	for (int j:i){
		        // 		System.out.print(j+",");
		        // 	}
		        // 	System.out.println();
		        // }
		        return dp[n-1]  [amount];
	 	}
}