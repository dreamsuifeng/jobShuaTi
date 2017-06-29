package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;

public class LongestAbsoluteFilePath388 {

	public int lengthLongestPath(String input) {
		int res = 0;
		String maxstr = "";
		char[] cs = input.toCharArray();
		int i = 0;
		LinkedList<String> pre = new LinkedList();
		while (i < cs.length) {
			int j = i;
			int count = 0;
			int label = i;
			boolean isfile = false;
			boolean flag = false;
			while (i < cs.length) {
				if (cs[i] == '.')
					isfile = true;
				// String t=input.substring(i,i+2);
				if (i + 1 < cs.length && input.substring(i, i + 1).equals("\n")) {
					flag=true;
					i += 1;
				}
				
				while (i + 1 < cs.length && input.substring(i, i + 1).equals("\t")) {
					flag = true;
					i += 1;
					count++;
				}
				if (flag) {
					break;
				} else {
					i++;
					label++;
				}
			}
			String tmp = input.substring(j, label);
//			System.out.println(tmp);
			pre.add(tmp);
			if (isfile) {
				String curpath = String.join("\\", pre);
//				System.out.println(curpath);
				if (curpath.length() > res) {
					res = curpath.length();
					maxstr = curpath;
				}
			}
			if (count < pre.size()) {
				int bound=pre.size()-count;
				for (int k = 0; k < bound; ++k) {
					pre.pollLast();
				}
			}

		}
//		System.out.println(maxstr);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		// System.out.println("dir\n\t file.txt\n\tfile2.txt".substring(7));
		System.out.println(new LongestAbsoluteFilePath388().lengthLongestPath(
				"a\n\taa\n\t\taaa\n\t\t\tfile1.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
	}

}
