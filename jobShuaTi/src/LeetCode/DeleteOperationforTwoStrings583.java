package LeetCode;

public class DeleteOperationforTwoStrings583 {
	public int minDistance(String word1, String word2) {
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int[][] dp=new int[w1.length][w2.length];
        int ans=0;
        for (int i=0;i<w1.length;++i){
        	for (int j=0;j<w2.length;++j){
        		if (w1[i]==w2[j]){
        			dp[i][j]= (i-1>=0 && j-1>=0) ?dp[i-1][j-1]:0 +1;
        		}else{
        			dp[i][j]=Math.max(i-1>=0?dp[i-1][j]:0, j-1>=0?dp[i][j-1]:0);
        		}
        		
        		ans=Math.max(ans, dp[i][j]);
        	}
        }
        return w1.length-ans+w2.length-ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
