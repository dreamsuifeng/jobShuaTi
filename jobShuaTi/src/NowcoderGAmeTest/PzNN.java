package NowcoderGAmeTest;

import java.util.Scanner;

public class PzNN {
	public static long solve(long[] d, int n, long A){
		for (int i=0;i<n;++i){
			if (A==d[i]){
				A*=2;
			}
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		long A=in.nextLong();
		long[] datas=new long[n];
		for (int i=0;i<n;++i){
			datas[i]=in.nextLong();
		}
		System.out.println(solve(datas, n, A));
	}

}
