package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
	    if(nums == null || nums.length == 0) return 0;
	    
	    Set<Integer> set = new HashSet<Integer>();
	    
	    for(int num: nums) set.add(num);
	    int max = 1;
	    for(int num: nums) {
	        if(set.remove(num)) {
	            int val = num;
	            int sum = 1;
	            while(set.remove(val-1)) val--;
	            sum += num - val;
	            
	            val = num;
	            while(set.remove(val+1)) val++;
	            sum += val - num;
	            
	            max = Math.max(max, sum);
	        }
	    }
	    return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testdata={0,1,3,2};
		longestConsecutiveSequence test=new longestConsecutiveSequence();
		System.out.println(test.longestConsecutive(testdata));
	}

}
