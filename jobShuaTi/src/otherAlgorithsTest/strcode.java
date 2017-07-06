package otherAlgorithsTest;

import java.util.Scanner;

public class strcode {
	public static int code(String s){
		int len=0;
		int index=0;
		int[] fact={1+25+25*25+25*25*25, 1+25+25*25, 1+25, 1};
		char[] sc=s.toCharArray();
		for (char c:sc){
			index+=fact[len++]*(c-'a');
		}
		return index+(len-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in=new Scanner(System.in);
//		String string=in.next();
//		System.out.println(code(string));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(1&31);
	}

}
