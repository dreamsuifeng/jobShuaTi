package LeetCode;

import java.util.HashMap;

public class ZumaGame488 {
	int MAXCOUNT = 6;   // the max balls you need will not exceed 6 since "The number of balls in your hand won't exceed 5"

	public int findMinStep(String board, String hand) {
	    int[] handCount = new int[26];
	    for (int i = 0; i < hand.length(); ++i) ++handCount[hand.charAt(i) - 'A'];
	    int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
	    return rs == MAXCOUNT ? -1 : rs;
	}
	private int helper(String s, int[] h) {
	    s = removeConsecutive(s);     
	    if (s.equals("#")) return 0;
	    int  rs = MAXCOUNT, need = 0;
	    for (int i = 0, j = 0 ; j < s.length(); ++j) {
	        if (s.charAt(j) == s.charAt(i)) continue;
	        need = 3 - (j - i);     //balls need to remove current consecutive balls.
	        if (h[s.charAt(i) - 'A'] >= need) {
	            h[s.charAt(i) - 'A'] -= need;
	            rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
	            h[s.charAt(i) - 'A'] += need;
	        }
	        i = j;
	    }
	    return rs;
	}
	//remove consecutive balls longer than 3
	private String removeConsecutive(String board) {
	    for (int i = 0, j = 0; j < board.length(); ++j) {
	        if (board.charAt(j) == board.charAt(i)) continue;
	        if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
	        else i = j;
	    }
	    return board;
	}
	public static void main(String[] args){
		String board="WWRRBBWW";
		String hand="WRBRW";
		ZumaGame488 test=new ZumaGame488();
		System.out.println(test.findMinStep(board, hand));
	}
}
