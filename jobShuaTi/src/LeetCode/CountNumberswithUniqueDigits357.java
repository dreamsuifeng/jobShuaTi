package LeetCode;

public class CountNumberswithUniqueDigits357 {
	public int countNumbersWithUniqueDigits(int n) {
        int[] dp=new int[n];
        int[] fab=new int[n];
        dp[0]=10;
        fab[0]=9;
        int step=9;
        for (int i=1;i<n;++i){
        	fab[i]=fab[i-1]*step;
        	dp[i]=dp[i-1]+fab[i];
        	step--;
        }
        return dp[n-1];
    }
	public static void main(String[] args){
		System.out.println(new CountNumberswithUniqueDigits357().countNumbersWithUniqueDigits(3));
	}
}
