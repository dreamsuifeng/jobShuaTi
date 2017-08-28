package DiDiContest;


import java.util.*;

public class LianxuMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long max=Integer.MIN_VALUE;
		int n=in.nextInt();
//		long[] d=new long[n];
		long sum=0;
		for (int i=0;i<n;++i){
			long t=in.nextLong();
			sum+=t;
			max=Math.max(max, sum);
			if (sum<0){
				sum=0;
			}
		}
		System.out.println(max);
	}

}
