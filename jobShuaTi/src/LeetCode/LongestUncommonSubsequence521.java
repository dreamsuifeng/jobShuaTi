package LeetCode;

import java.util.Arrays;

public class LongestUncommonSubsequence521 {
	public int findLUSlength(String a, String b) {
		if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
		
    }
	
	
	public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        for (int i = 0; i < strs.length; i++) {
            boolean found = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[j],strs[i])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return strs[i].length();
            }
        }
        
        return -1;
    }

    /**
     *
     * @return true if str2 is a subsequence of str1, false otherwise.
     */
    private boolean isSubsequence(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }

        if (str1.length() < str2.length()) {
            return false;
        }

        int i = 0;
        for (char ch : str1.toCharArray()) {
            if (i < str2.length() && str2.charAt(i) == ch) {
                i++;
            }
        }
        return i == str2.length();
    }
}
