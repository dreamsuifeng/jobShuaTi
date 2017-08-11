package NowcoderGAmeTest;

import java.util.Scanner;

public class net2017qiu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long r=in.nextLong();
		long res=0;
		long ri=(long) Math.sqrt(r);
		long upbound=ri;
		for (long i=0l;i<=upbound;++i){
			long y=(long) (r-Math.pow(i, 2));
			y=(long) Math.sqrt(y);
			if (Math.pow(i, 2)+Math.pow(y, 2)==r){
				res++;
			}
		}
		if (Math.pow(ri, 2)==r){
			res-=1;
		}
		res*=4;
		System.out.println(res);
	}

}
