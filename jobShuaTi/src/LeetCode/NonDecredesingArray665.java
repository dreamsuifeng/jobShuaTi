package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sun.javafx.image.IntPixelAccessor;

public class NonDecredesingArray665 {
	
	public int longestIncreaseSubsequence(int[] seq) {
        int n = seq.length;
        int[] count=new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (seq[j] < seq[i]) {
                	max = Math.max(max, count[j]);
                }
            }
            count[i] = max + 1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
        	System.out.print(count[i]+",");
            if (count[i] > max) max = count[i];
        }

        return max;
    }
	
	public int longestIncreSeq(int[] nums){
		List<Integer> tmp=new ArrayList<>();
		for (int i:nums){
			int index=Collections.binarySearch(tmp, i);
			if (index>=0){
				tmp.add(index, i);
			}else{
				index=-(index+1);
				tmp.set(index, i);
			}
		}
		return tmp.size();
	}
	public boolean checkPossibility(int[] nums) {
		 int n = nums.length, count = 0;
	        
	        for (int i = 0; i + 1 < n; i++) {
	            if (nums[i] > nums[i + 1]) {
	                count++;
	                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
	                else nums[i] = nums[i + 1];
	            }
	        }
	            
	        return count <= 1;
    }
	
	
}
