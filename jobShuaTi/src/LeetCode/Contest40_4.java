package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Contest40_4 {
	
	public int numDecodings(String s) {
    	long div = 1_000_000_007;
    	if (s.isEmpty()) {
    		return 1;
    	}
    	long[] dp = new long[s.length() + 1];
    	dp[0] = 1;
    	char c0 = s.charAt(0);
    	if (c0 == '*') {
    		dp[1] = 9;
    	} else if(c0 == '0') {
    		return 0;
    	} else {
    		dp[1] = 1;
    	}
    	Set<Character> set2 = new HashSet<>();
    	set2.addAll(Arrays.asList('1','2','3','4','5','6'));
    	
    	for (int i = 1; i < s.length(); i++) {
    		char curr = s.charAt(i);
    		char prev = s.charAt(i-1);
    		long prevCnt = dp[i];
    		long prevPrevCnt = dp[i-1];
    		if (curr == '0') {
    			if (prev == '1' || prev == '2') {
    				dp[i+1] = prevPrevCnt;
    			} else if (prev == '*') {
    				dp[i+1] = (prevPrevCnt * 2) % div;
    			} else {
    				return 0;
    			}
    		} else if (curr == '*') {
    			long currCnt = prevCnt * 9;
    			if (prev == '1') {
    				currCnt = currCnt + prevPrevCnt * 9;
    			} else if (prev == '2') {
    				currCnt = currCnt + prevPrevCnt * 6;
    			} else if (prev == '*') {
    				currCnt = currCnt + prevPrevCnt * 15;
    			}
    			dp[i+1] = currCnt % div;
    		} else {
    			long currCnt = prevCnt;
    			if (prev == '1') {
    				currCnt += prevPrevCnt;
    			} else if (prev == '2' && set2.contains(curr)) {
    				currCnt += prevPrevCnt;
    			} else if (prev == '*') {
    				if (set2.contains(curr)) {
    					currCnt += prevPrevCnt * 2;
    				} else {
    					currCnt += prevPrevCnt;
    				}
    			}
    			dp[i+1] = currCnt % div;
    		}
    	}
    	return (int) dp[s.length()];
    }
	public static void main(String[] args){
		
		
	}
}
