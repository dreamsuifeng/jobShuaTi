package LeetCode;

import java.util.Scanner;

public class AliTest1 {
	static double computeExcepted(int N){
		double result=0.0;
		for(int i=1;i<=N;++i){
			result+=1.0/i;
		}
		return result*N;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		@SuppressWarnings("resource")
//		Scanner in=new Scanner(System.in);
//		int N=in.nextInt();
//		double result=computeExcepted(N);
//		double print=(3-2)/(4-1);
//		System.out.println(print);
		String s1="abc";
		String s2="abc";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println("test");
		}
}
