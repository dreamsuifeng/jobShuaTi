package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu4 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		while (in.hasNext()){
			int n=in.nextInt();
			if (n<3){
				System.out.println((int)Math.pow(3, n));
			}else{
				long all=(long) Math.pow(3, n);
				long[] dp=new long[n];
				dp[0]=3;
				dp[1]=9;
				dp[2]=21;
				for (int i=3;i<n;++i){
					dp[i]=2*dp[i-1]+dp[i-2];
				}
				System.out.println(dp[n-1]);
			}
			
		}
		
		
	}
}
