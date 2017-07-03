package LeetCode;

public class IntegerReplacement397 {
	public static int integerReplacement(int n) {
		if (n==1 || n==2) return n-1;
        int[] dp=new int[n+1];
        dp[1]=0;
        dp[2]=1;
        int res=1;
        for (int i=3;i<=n;++i){
        	if (i%2==0){
        		dp[i]=Math.min(dp[i/2]+1, dp[i-1]+1);
        	}else{
        		dp[i]=Math.min(dp[i-1]+1, dp[(i+1)/2]+2);
        	}
        }
        return dp[n];
    }
	public static int integerReplacement1(int n) {
		if(n==Integer.MAX_VALUE) return 32; //n = 2^31-1;
	    int count = 0;
	    while(n>1){
	        if(n%2==0) n/=2;
	        else{
	            if((n+1)%4==0&&(n-1!=2)) n++;
	            else n--;
	        }
	        count++;
	    }
	    return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Math.log10(1024)/Math.log10(2));
		System.out.println(integerReplacement1(1000));
//		System.out.println(integerReplacement(65532));
	}

}
