package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO521 {
	public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		if (k==0) return W;
        int n=Profits.length;
        int[][] data=new int[n][2];
        for (int i=0;i<n;++i){
        	data[i][0]=Profits[i];
        	data[i][1]=Capital[i];
        	
        }
        k=Math.min(k,n);
        Arrays.sort(data,(x,y)->x[1]-y[1]);
        if (W<data[0][1]) return W;
        int[] dp=new int[k+1];
        for (int i=1;i<=n;++i){
        	if (i==1) {
        		dp[1]=data[i-1][0]+W;
        		continue;
        	}
        	for (int j=Math.min(k,i);j>=1;--j){
        		if (dp[j-1]<data[i-1][1]){
        			dp[j]=dp[j];
        		}else{
        			dp[j]=Math.max(dp[j], dp[j-1]+data[i-1][0]);
        		}
                if (j==1){
                	if (W>=data[i-1][1]){
            			dp[1]=Math.max(dp[1], data[i-1][0]+W);
            		}else{
            			dp[1]=dp[1];
            		}
                }
        	}
        }
        return dp[k];
    }
	
	public int findMaximizedCapital1(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqPro  = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]});
        }
        
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll());
            }
            
            if (pqPro.isEmpty()) break;
            
            W += pqPro.poll()[1];
        }
        
        return W;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
