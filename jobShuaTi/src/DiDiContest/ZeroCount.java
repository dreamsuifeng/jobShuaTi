package DiDiContest;

import java.util.Scanner;

public class ZeroCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int ans=0;
		int n=in.nextInt();
		while(n>0)
	    {
	        ans += n / 5;
	        n = n / 5;
	    }
		System.out.println(ans);
	}

}
