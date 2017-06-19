package NowcoderGAmeTest;

import java.util.Arrays;
import java.util.Scanner;

public class clele61 {
	public static int solve(int n, int[] h){
		Arrays.sort(h);
		int res=0;
		for (int i=2;i<n;++i){
			res=Math.max(res,h[i]-h[i-2]);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] h=new int[n];
		for (int i=0;i<n;++i){
			h[i]=in.nextInt();
		}
		System.out.println(solve(n, h));
	}

}
