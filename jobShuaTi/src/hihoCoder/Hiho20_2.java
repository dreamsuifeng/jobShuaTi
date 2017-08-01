package hihoCoder;

import java.util.Scanner;

public class Hiho20_2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for (int i=0;i<T;++i){
			int N=in.nextInt();
			for (int j=(int) (Math.sqrt(N*2-1));j>=1;--j){
				if ((N-j*(j-1)/2)%j==0){
					System.out.println(j);
					break;
				}
			}
		}
	}
}
