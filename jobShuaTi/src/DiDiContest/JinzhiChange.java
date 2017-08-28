package DiDiContest;


import java.util.*;

public class JinzhiChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long m=in.nextLong();
		int jinzhi=in.nextInt();
		String res=Long.toString(m, jinzhi);
		res=res.toUpperCase();
		System.out.println(res);
	}

}
