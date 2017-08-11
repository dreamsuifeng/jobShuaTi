package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu5 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String x=in.next();
		String y=in.next();
		x=new StringBuffer(x).reverse().toString();
		y=new StringBuffer(y).reverse().toString();
		int xx=Integer.parseInt(x);
		int yy=Integer.parseInt(y);
		String sum=String.valueOf(xx+yy);
		
		
		System.out.println(Integer.parseInt(new StringBuffer(sum).reverse().toString()));
	}
}
