package hihoCoder;

import java.util.Scanner;

public class xing2_1 {
	static int res;
	static void swap(char[] s,int i,int j){
		char tmp=s[i];
		s[i]=s[j];
		s[j]=tmp;
	}
	static void help(char[] s,char[] t,int p, int c,int n){
		if (p>=n){
			res=Math.min(res, c);
			return;
		}
		if (s[p]==t[p]) help(s, t, p+1, c, n);
		else{
			for (int j=p+1;j<n;++j){
				if (s[j]==t[p]){
					swap(s, p, j);
					help(s, t, p+1, c+1, n);
					swap(s, p, j);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		for (int i=0;i<n;++i){
			char[] s=in.next().toCharArray();
			char[] t=in.next().toCharArray();
			res=s.length;
			help(s, t, 0, 0, s.length);
			System.out.println(res);
			
		}
	}

}
