package LeetCode;

public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		
		//if k >= n/2, then you can make maximum number of transactions.
		if (k >=  n/2) {
			int maxPro = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] > prices[i-1])
					maxPro += prices[i] - prices[i-1];
			}
			return maxPro;
		}
		
	    int[][] dp = new int[k+1][n];
	    for (int i = 1; i <= k; i++) {
	    	int localMax = dp[i-1][0] - prices[0];
	    	for (int j = 1; j < n; j++) {
	    		dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
	    		localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
	    	}
	    }
	    return dp[k][n-1];
	}
	public int maxProfit(int[] prices) {
        int res=Integer.MIN_VALUE;
        int preMinPrices=Integer.MAX_VALUE;
        int[] dpSold=new int[prices.length];
        for(int i=0;i<prices.length;++i){
            if (prices[i]<preMinPrices){
                preMinPrices=prices[i];
            }
            int temp=prices[i]-preMinPrices;
            res=res>temp ? res:temp;
            dpSold[i]=res;
        }
        int postMax=Integer.MIN_VALUE;
        int postMaxPrices=Integer.MIN_VALUE;
        int[] dpBuy=new int[prices.length];
        for (int j=prices.length-1;j>=0;--j){
            if (prices[j]>postMaxPrices){
                postMaxPrices=prices[j];
            }
            int temp2=postMaxPrices-prices[j];
            postMax=postMax>temp2 ? postMax:temp2;
            dpBuy[j]=postMax;
        }
        int k=0;
        while(k<prices.length){
            int temp=dpSold[k]+dpBuy[k];
            if (temp>res) res=temp;
            k++;
        }
        // for(Integer i:dpSold){
        //     System.out.print(i+",");
        // }
        // System.out.println();
        // for(Integer j:dpBuy){
        //     System.out.print(j+",");
        // }
        return res>0 ? res:0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
