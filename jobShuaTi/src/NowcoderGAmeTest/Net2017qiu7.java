package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu7 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int s=n/8;
		boolean flag=true;
		for (int i=s;i>=0;--i){
			if ((n-8*i)%6==0){
				System.out.println(i+(n-8*i)/6);
				flag=false;
				break;
			}
		}
		if (flag)
			System.out.println(-1);
	}
}
