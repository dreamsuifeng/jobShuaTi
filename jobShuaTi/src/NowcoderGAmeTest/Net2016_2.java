package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2016_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int r=in.nextInt();
		int x1=in.nextInt();
		int y1=in.nextInt();
		int x2=in.nextInt();
		int y2=in.nextInt();
		int x3=in.nextInt();
		int y3=in.nextInt();
		int x0=in.nextInt();
		int y0=in.nextInt();
		int d1=(int) ( Math.pow(x1-x0,2)+Math.pow(y1-y0, 2));
		int d2=(int) (Math.pow(x2-x0,2)+Math.pow(y2-y0, 2));
		int d3=(int) (Math.pow(x3-x0,2)+Math.pow(y3-y0, 2));
		int ans=0;
		if (d1<=r*r) ans++;
		if (d2<=r*r) ans++;
		if (d3<=r*r) ans++;
		System.out.println(ans+"x");
	}

}
