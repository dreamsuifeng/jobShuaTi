package LeetCode;

import java.util.Arrays;

public class MaxlenParichain {
	public int findLongestChain(int[][] pairs) {
		if (pairs==null || pairs.length==0) return 0;
		Arrays.sort(pairs,(x,y)->x[0]!=y[0] ? x[0]-y[0]:x[1]-y[1]);
		int[] dp=new int[pairs.length];
		int s=pairs[0][0],e=pairs[0][1];
		dp[0]=1;
		for (int i=1;i<pairs.length;++i){
			int maxlen=Integer.MIN_VALUE;
			for (int j=0;j<i;++j){
				if (pairs[i][0]>pairs[j][1]){
					maxlen=Math.max(maxlen, dp[j]+1);
				}
			}
			dp[i]=maxlen;
		}
		return dp[pairs.length-1];
    }
}
