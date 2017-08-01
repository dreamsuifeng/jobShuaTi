package hihoCoder;

import java.util.Scanner;

public class DiligentRobots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long N=in.nextLong();
		int Q=in.nextInt();
		int k=0;
		long numRots=(long) Math.pow(2, k);
		int res=Integer.MAX_VALUE;
		while (numRots<=N){
			int t=(int) (Math.ceil((double)N/numRots)+Q*k);
			res=Math.min(res, t);
			k++;
			numRots=(long) Math.pow(2, k);
		}
		System.out.println(res);
	}

}
