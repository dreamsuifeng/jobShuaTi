package NowcoderGAmeTest;

import java.util.Scanner;

public class MostMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long[] d=new long[n];
		for (int i=0;i<n;++i){
			d[i]=in.nextLong();
		}
		long a=Long.MIN_VALUE,b=a,c=a;
		long e=Long.MAX_VALUE,f=Long.MAX_VALUE;
		for (Long i:d){
			 if (i>a){
				 c=b;
				 b=a;
				 a=i;
				 
			 }else if (i>b){
				 c=b;
				 b=i;
			 }else if (i>c){
				 c=i;
			 }
			 
			 if (i<e){
				 f=e;
				 e=i;
			 }else if (i<f){
				 f=i;
			 }
			
		}
		
		long a1=a*b*c;
		long a2=a*e*f;
		System.out.println(Math.max(a1, a2));
	}

}
