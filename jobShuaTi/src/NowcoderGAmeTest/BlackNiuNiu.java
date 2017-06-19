package NowcoderGAmeTest;

import java.util.Scanner;

public class BlackNiuNiu {
	public static int solve(String s){
		char[] cs=s.toCharArray();
		int res=1;
		for (int i=1;i<cs.length;++i){
			if (cs[i]!=cs[i-1]) res++;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s=in.next();
		System.out.println(solve(s));
	}

}
