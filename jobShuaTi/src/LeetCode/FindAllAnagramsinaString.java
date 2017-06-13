package LeetCode;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
	    List<Integer> list = new ArrayList<>();
	    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
	    int[] hash = new int[256]; 
	
	    for (char c : p.toCharArray()) {
	        hash[c]++;
	    }
	    
	    int left = 0, right = 0, count = p.length();
	    while (right < s.length()) {
	        
	        if (hash[s.charAt(right++)]-- >= 1) count--; 
	        
	        
	        if (count == 0) list.add(left);
	    
	        
	        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
	    }
	    return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindAllAnagramsinaString t=new FindAllAnagramsinaString();
		System.out.println(t.findAnagrams("cbaebabaccbaebabac", "abc"));
		int[] a={0,2,3,4,5};
		if (a[0]++>0);
		System.out.println(a[0]);
	}

}
