package XiaoZhao;

import java.util.Scanner;

public class Wangyi_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		char[] s=in.next().toCharArray();
		if (s.length==1){
			System.out.println(1);
			return;
		}
		int i=0,j=1;
		int ans=0;
		while (j<s.length){
			while (j<s.length && s[j]!=s[j-1]) j++;
			ans=Math.max(ans, j-i);
			i=j;
			j++;
		}
		ans=Math.max(ans, j-i);
		System.out.println(ans);
	}

}
