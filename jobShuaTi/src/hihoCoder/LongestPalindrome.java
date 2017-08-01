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
	private static int LongestPalindrome(char[] s){
		char[] snew=new char[2*s.length+1];
		int j=0;
		int maxlen=0;
		for (int i=0;i<s.length;++i){
			snew[j]='*';
			j++;
			snew[j]=s[i];
			j++;
		}
		snew[snew.length-1]='*';
		int[] dp=new int[snew.length];
		int id=0,mx=0;
		for (int i=1;i<snew.length;++i){
			dp[i]=mx>i ? Math.min(dp[2*id-i], mx-i):1;
			while (i+dp[i]<snew.length && i-dp[i]>=0){
				 if (snew[i+dp[i]]==snew[i-dp[i]]){
					 dp[i]++;
				 }else{
					 break;
				 }
				
			}
			dp[i]--;
			if (i+dp[i] > mx){
				mx=i+dp[i];
				id=i;
			}
			maxlen=Math.max(maxlen, 2*dp[i]+1);
		}
		System.out.println(maxlen);
		return maxlen/2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		int N=in.nextInt();
		for (int i=0;i<N;++i){
			System.out.println(LongestPalindrome(in.next().toCharArray()));
		}
	}
	}
