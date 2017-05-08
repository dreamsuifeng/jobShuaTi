package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PalindromePartitioning {
	private List<List<String>> res = new LinkedList<List<String>>();
	private Set<String> usedString=new  HashSet<>();
	private boolean isPalindrome(String s1, String s2, String ...args){
		String temp=s1+s2;
		for (int k=0;k<args.length;++k){
			temp+=args[k];
		}
		int i=0, j=temp.length()-1;
		while(i<j){
			if (temp.charAt(i)!=temp.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	void findSubPalindrome(List<String> tmplist1){
		Queue<List<String>> help=new LinkedList<>();
		help.add(tmplist1);
		while (!help.isEmpty()){
			List<String> tmplist=help.poll();
			for (int i=0;i<tmplist.size()-1;++i){
				if (isPalindrome(tmplist.get(i), tmplist.get(i+1))){
					LinkedList<String> listTmp=new LinkedList<>(tmplist);
					listTmp.remove(i);
					listTmp.remove(i);
					String tmpString=tmplist.get(i)+","+tmplist.get(i+1);
					listTmp.add(i,tmplist.get(i)+tmplist.get(i+1));
					if (!usedString.contains(tmpString)) {
						res.add(listTmp);
						usedString.add(tmpString);
					}
					
//					findSubPalindrome(listTmp);
					help.add(listTmp);
					
				}
			}
			for (int j=0;j<tmplist.size()-2;++j){
				if (isPalindrome(tmplist.get(j), tmplist.get(j+1), tmplist.get(j+2))){
					LinkedList<String> listTmp=new LinkedList<>(tmplist);
					listTmp.remove(j);
					listTmp.remove(j);
					listTmp.remove(j);
					listTmp.add(j,tmplist.get(j)+tmplist.get(j+1)+tmplist.get(j+2));
					String tmpString=tmplist.get(j)+","+tmplist.get(j+1)+","+tmplist.get(j+2);
					if (!usedString.contains(tmpString)){
						res.add(listTmp);
						usedString.add(tmpString);
					}
//					findSubPalindrome(listTmp);
					help.add(listTmp);
				}
			}
		}
	}

	public List<List<String>> partition(String s) {
		LinkedList<String> l1=new LinkedList<>();
		for(int i=0;i<s.length();++i){
			l1.add(""+s.charAt(i));
		}
		res.add(new LinkedList<>(l1));
		findSubPalindrome(l1);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning tPalindromePartitioning=new PalindromePartitioning();
		System.out.println(tPalindromePartitioning.partition("").toString());
		
	}
//	 public List<List<String>> partition(String s) {
//	        List<List<String>> res = new ArrayList<List<String>>();
//	        if (s.equals("")) {
//	            res.add(new ArrayList<String>());
//	            return res;
//	        }
//	        for (int i = 0; i < s.length(); i++) {
//	            if (isPalindrome(s, i + 1)) {
//	                for (List<String> list : partition(s.substring(i+1))) {
//	                    list.add(0, s.substring(0, i + 1));
//	                    res.add(list);
//	                }
//	            }
//	        }
//	        return res;
//	    }
//	    
//	    public boolean isPalindrome(String s, int n) {
//	        for (int i = 0, j=n-1; i < j; i++,j--) {
//	            if (s.charAt(i) != s.charAt(j))
//	                return false;
//	        }
//	        return true;
//	    }
}
