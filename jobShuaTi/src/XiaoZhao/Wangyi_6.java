package XiaoZhao;

import java.util.Scanner;

public class Wangyi_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long x=in.nextLong();
		long f=in.nextLong();
		long d=in.nextLong();
		long p=in.nextLong();
		long days=d/x;
		if (days<=f){
			System.out.println(days);
			return;
		}
		long ans=f;
		long remainM=d-f*x;
		System.out.println(ans+remainM/(x+p));
	}

}
