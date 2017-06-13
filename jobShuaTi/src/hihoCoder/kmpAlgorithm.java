package hihoCoder;

import java.util.Arrays;
import java.util.Scanner;

public class kmpAlgorithm {
	public static int[] next(char[] t) { 
//		t=Arrays.copyOf(t, t.length+1);
//		t[t.length-1]='#';
		
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
        int[] next = next(t);  
        int i = 0;  
        int j = 0;  
        while (i <= s.length - 1 && j <= t.length - 1) {  
            if (j == -1 || s[i] == t[j]) {  
                i++;  
                j++;  
            } else {  
                j = next[j];  
            }  
        }  
        if (j < t.length) {  
            return -1;  
        } else  
            return i - t.length; // 返回模式串在主串中的头下标  
    }  
	
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		@SuppressWarnings("resource")
//		Scanner in=new Scanner(System.in);
//		
//		while (in.hasNext()) {
//			int tests=in.nextInt();
//			String[] testSting=new String[tests*2];
//			for (int i=0;i<testSting.length;++i){
//				testSting[i]=in.next();
//			}
//			for (int j=0;j<tests;++j){
//				char[] t=testSting[j*2].toCharArray();
//				char[] s=testSting[j*2+1].toCharArray();
//				System.out.println(KMP_Index(s, t));
//			}
//			
//			}
	
		char[] t="abcddeabcabcabc".toCharArray();
		char[] cs="abc".toCharArray();
		int[] a=next("abcabc".toCharArray());
//		for (int i : a) {
//			System.out.print(i+",");
//		}
		System.out.println(KMP_Index(t, cs));
//		System.out.println(cs);
		}
	}

