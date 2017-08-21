package hihoCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import LeetCode.test;

public class Challenge30_1 {
	static class node{
		int s;
		int e;
		public node(int s,int e){
			this.s=s;
			this.e=e;
		}
	}
	
	public static List<node> findSeq(String sf, String sr){
		char[] s1=sf.toCharArray();
		char[] s2=sr.toCharArray();
		List<node> ans=new LinkedList<>();
		for (int i=0;i<s2.length;++i){
			if (s2[i]==s1[0]){
				int k=i+1;
				int j=1;
				while (k<s2.length && j<s1.length){
					if (s1[j]==s2[k]){
						k++;
						j++;
					}else{
						k++;
					}
					
				}
				if (j==s1.length){
					node t=new node(i, k-1);
					ans.add(t);
				}
			}
		}
		return ans;
	}
	
	public static int findMinStr(List<node> r1,List<node> r2, char[] s3, char[] s1,char[] s2){
		int ans=Integer.MAX_VALUE;
		for (int i=0;i<r1.size();++i){
			for (int j=0;j<r2.size();++j){
				int l=Math.min(r1.get(i).s, r2.get(j).s);
				int r=Math.max(r1.get(i).e, r2.get(j).e);
				ans=Math.min(ans, computeDis(l, r, s3, s1, s2));
			}
		}
		return ans;
	}
	
	public static int computeDis(int l, int r, char[] s3,char[] s1,char[] s2){
		String aString="";
		String bString="";
		String cString="";
		int s1i=0,s2i=0;
		for (int i=l;i<=r;++i){
			if (s1i<s1.length && s3[i]==s1[s1i]){
				aString+=""+s3[i];
				s1i++;
			}else if (s2i<s2.length && s3[i]==s2[s2i]){
				bString+=""+s3[i];
				s2i++;
			}else {
				cString+=""+s3[i];
			}
		}
		char[] s4=cString.toCharArray();
		if (isInter(s1, s2) && isInter(s2, s4) && isInter(s4, s1)){
			return r-l+1;
		}
		return Integer.MAX_VALUE;
		
		
	}
	
	public static boolean isInter(char[] s1, char[] s2){
		HashSet<Character> set=new HashSet<>();
		for (char c:s1){
			set.add(c);
		}
		for (char c:s2){
			if (set.contains(c)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s1=in.nextLine();
		String s2=in.nextLine();
		String s3=in.nextLine();
		if (s3.length()<s1.length()+s2.length()){
			System.out.println(-1);
			return;
		}
		List<node> r1=findSeq(s1, s3);
		List<node> r2=findSeq(s2, s3);
		int ans=findMinStr(r1, r2, s3.toCharArray(), s1.toCharArray(), s2.toCharArray());
		if (ans==Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
	}

}
