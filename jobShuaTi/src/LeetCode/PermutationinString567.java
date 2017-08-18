package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class PermutationinString567 {
	public boolean checkInclusion(String s1, String s2) {
        int[] p1=new  int[26];
        int[] p2=new int[26];
        char[] s1s=s1.toCharArray();
        char[] s2s=s2.toCharArray();
        for (char c:s1s){
        	p1[c-'a']++;
        	
        }
        for (int i=0; i<s2s.length; ++i){
        	p2[s2s[i]]++;
        	if (i>=s1s.length-1){
        		boolean flag=true;
        		for (int j=0;i<26;++j){
        			if (p1[j]!=p2[j]){
        				flag=false;
        				break;
        			}
        		
        		}
        		if (flag) return true;
        	}
        	
        	if (i>=s1s.length-1){
        		p2[s2s[i-s1s.length+1]]--;
        	}
        }
        return false;
        
        
    }
	public static boolean isprime(int n){
	    int sq=(int)Math.sqrt(n);
	    for (int i=2;i<=sq;++i){
	      if (n%i==0) return false;}
	    return true;
	  }
	  public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    int n=in.nextInt();
	  	 int i=0;
	    int s=2;
	    while (true){
	      if (isprime(s)){
	        i++;
	      }
	      if (i==n) {
	        System.out.println(s);
	        return;
	      }
	      s++;
	  }
	}
}
