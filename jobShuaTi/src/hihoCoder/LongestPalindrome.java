package hihoCoder;
import java.util.Scanner;

public class LongestPalindrome {
	static int extendCenter(char[] s, int i, int j){
		int right=j;
		int left=i;
		while (( right<s.length && left>=0 && s[right]==s[left])){
			left-=1;
			right+=1;
			
		}
		return right-left-1;
	}
	static void LongestPalin(char[] s){
		if (s.length==1 || s.length==0){
			System.out.println(s.length);;
		}else{
			int result=-1;
			for (int i = 0;i<s.length;++i){
				int temp1=extendCenter(s, i, i);
				int temp2=extendCenter(s, i, i+1);
				int temp=temp1>temp2?temp1:temp2;
				result=result>temp?result:temp;
			}
			System.out.println(result);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		while (in.hasNext()) {
			int tests=in.nextInt();
			String[] testSting=new String[tests];
			for (int i=0;i<testSting.length;++i){
				testSting[i]=in.next();
			}
			for (int j=0;j<tests;++j){
				char[] test=testSting[j].toCharArray();
				LongestPalin(test);
			}
			
			}
			
		}
	}
