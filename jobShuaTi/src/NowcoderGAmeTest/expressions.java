package NowcoderGAmeTest;

import java.util.Scanner;

public class expressions {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		char[] sc=in.nextLine().toCharArray();
		int pre=0;
		int second=0;
		char op='+';
		int ans=0;
		for (char c:sc){
			if (Character.isDigit(c)){
				second=second*10+Integer.parseInt(""+c);
			}else{
				if (op=='+'){
					ans=pre+second;
				}else if (op=='-'){
					ans=pre-second;
				}else {
					ans=pre*second;
				}
				
				pre=ans;
				second=0;
				op=c;
			}
		}
		if (op=='+'){
			ans=pre+second;
		}else if (op=='-'){
			ans=pre-second;
		}else {
			ans=pre*second;
		}
		
		System.out.println(ans);
	}
}	
