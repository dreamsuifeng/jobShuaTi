package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class KmpAlgorithm {
	public static int[] next(char[] t) { 
		t=Arrays.copyOf(t, t.length+1);
		t[t.length-1]='#';
        int[] next = new int[t.length];  
        next[0] = -1;  
        int i = 0;  
        int j = -1;  
        while (i < t.length - 1) {  
            if (j == -1 || t[i] == t[j]) {  
                i++;  
                j++;  
                if (t[i] != t[j]) {  
                    next[i] = j;  
                } else {  
                    next[i] = next[j];  
                }  
            } else {  
                j = next[j];  
            }  
        }  
        return next;  
    }  
	public static int KMP_Index(char[] s, char[] t) {
		int result=0;
        int[] next = next(t);  
        int i = 0;  
        int j = 0; 
        // int outindex=0;
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }
            if (j==t.length) {
				result+=1;
//				i=i-t.length+1;
				j=next[t.length];
			}
        }  
	        
		return result; 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int tests=in.nextInt();
		while (in.hasNext()) {
// 			int tests=in.nextInt();
		    char[] t=in.next().toCharArray();
		    char[] s=in.next().toCharArray();
		    System.out.println(KMP_Index(s, t));
			
			}
			
		}
}
