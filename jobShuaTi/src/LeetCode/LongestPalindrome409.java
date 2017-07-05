package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LongestPalindrome409 {
	public int longestPalindrome(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        char[] cs=s.toCharArray();
        for (Character c:cs){
        	map.compute(c, (k,v)->(v==null ? 1:v+1));
        }
        Iterator<Integer> it=map.values().iterator();
        int res=0;
        while (it.hasNext()){
        	Integer i=it.next();
        	res+=(i%2==0 ? i:i-1);
        }
        return res==s.length() ? res:res+1;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
