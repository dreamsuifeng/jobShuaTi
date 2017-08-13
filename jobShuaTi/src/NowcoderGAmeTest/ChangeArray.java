package NowcoderGAmeTest;

import java.util.Scanner;

public class ChangeArray {
	public static int solve(char[] s){
		int j=0;
		int ans1=0;
		for (int i=0;i<s.length;++i){
			if (s[i]=='B'){
				ans1+=i-j;
				j++;
			}
			
		}
		int ans2=0;
		int jj=0;
		for (int i=0;i<s.length;++i){
			if (s[i]=='G'){
				ans2+=i-jj;
				jj++;
			}
		}
		return ans2<ans1?ans2:ans1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		char[] s=in.nextLine().toCharArray();
		System.out.println(solve(s));
	}

}
