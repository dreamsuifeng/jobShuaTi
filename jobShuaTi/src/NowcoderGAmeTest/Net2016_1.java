package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2016_1 {
	
	public static long solve(long a,long b){
		while (b!=0){
			long t=a%b;
			a=b;
			b=t;
		}
		return a;
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			long inival=in.nextLong();
			long[] b=new long[n];
			for (int i=0;i<n;++i){
				b[i]=in.nextLong();
			}
			for (long i:b){
				if (i<=inival){
					inival+=i;
					
				}else{
					inival+=solve(i, inival);
				}
			}
			System.out.println(inival);
			
		}
		
	}
}
