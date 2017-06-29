package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;

public class LongestAbsoluteFilePath388 {

	public int lengthLongestPath(String input) {
		int res=0;
		String maxstr="";
		char[] cs=input.toCharArray();
		int i=0;
		LinkedList<String> pre=new LinkedList();
		while (i<cs.length){
			int j=i;
			int count=0;
			int label=i;
			boolean isfile=false;
			while (i<cs.length){
				if (cs[i]=='.') isfile=true;
//				String t=input.substring(i,i+2);
				if (i+2<cs.length && input.substring(i,i+1).equals("\n")){
					label=i;
					i+=1;
				}
				boolean flag=false;
				while (i+2<cs.length && input.substring(i,i+1).equals("\t")){
					flag=true;
					i+=1;
					count++;
				}
				if (flag){
					break;
				}else{
					i++;
				}
			}
			String tmp=input.substring(j,label);
//			System.out.println(tmp);
			pre.add(tmp);
			if (isfile){
				String curpath=String.join("\\", pre);
				if(curpath.length()>res){
					res=curpath.length();
					maxstr=curpath;
				}
			}
			if (count<pre.size()){
				for (int k=0;k<pre.size()-count;++k){
					pre.pollLast();
				}
			}
			
		}
		System.out.println(maxstr);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
//		System.out.println("dir\n\t        file.txt\n\tfile2.txt".substring(7));
		System.out.println(new LongestAbsoluteFilePath388().lengthLongestPath(
				"a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));
	}

}
