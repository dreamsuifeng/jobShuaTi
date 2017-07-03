package LeetCode;

import java.util.HashMap;


public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		char[] sc=s.toCharArray();
	    return dc(sc, 0, s.length(), k);
	}
	    
	public int dc(char[] s, int start, int end, int k) {
	    if (end - start < k) return 0;
	    int[] cnt = new int[26];
	    for (int i = start; i < end; i++) {
	        cnt[s[i] - 'a']++;
	    }
	    for (int i = start; i < end; i++) {
	        if (cnt[s[i] - 'a'] < k) {
	            return Math.max(dc(s, start, i, k), dc(s, i + 1, end, k));
	        }
	    }
	    return end - start;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringwithAtLeastKRepeatingCharacters395 t=new LongestSubstringwithAtLeastKRepeatingCharacters395();
		System.out.println(t.longestSubstring("ababbc", 2));
	}

}
