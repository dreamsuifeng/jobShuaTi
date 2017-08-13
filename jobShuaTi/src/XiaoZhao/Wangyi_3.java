package XiaoZhao;

import java.util.Scanner;

public class Wangyi_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		char[] s=in.next().toCharArray();
		int[] zhuan=new int[26];
		for (char c:s){
			zhuan[c-'A']++;
		}
		int kinds=0;
		for (int i:zhuan){
			if (i>0) kinds++;
		}
		if (kinds>2){
			System.out.println(0);
		}else{
			if (kinds==1){
				System.out.println(1);
			}else{
				System.out.println(2);
			}
			
		}
	}

}