package NowcoderGAmeTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class SeceseSwap {
	public static int solve(int[] d, int n){
		int res=0;
		int f=0;
		for (int i=0;i<n;++i){
//			if (i>0 && d[i]==d[i-1]) continue;
			
			for (int j=i+1;j<n;++j){
				if (d[j]==d[i] && f==0){
					f=1;
					res++;
				}
				if (d[j]!=d[i])res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int[] datas=new int[n];
		for (int i=0;i<n;++i){
			datas[i]=in.nextInt();
		}
		System.out.println(solve(datas, n));
	}
}
