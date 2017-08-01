package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class MatchstickstoSquare473 {
	private boolean dfs(int[] nums, int[] sums, int index, int target) {
    	if (index == nums.length) {
    	    if (sums[0] == target && sums[1] == target && sums[2] == target) {
    		return true;
    	    }
    	    return false;
    	}
    	
    	for (int i = 0; i < 4; i++) {
    	    if (sums[i] + nums[index] > target) continue;
    	    sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
    	    sums[i] -= nums[index];
    	}
    	
    	return false;
    }
	public boolean makesquare(int[] nums) {
        int n=nums.length;
        List<Integer> numlist=new LinkedList<>();
        int sum=0;
        for (int i:nums){
        	sum+=i;
        }
        if (sum%4!=0){
        	return false;
        }else{
        	int len=sum/4;
        	return dfs(nums,new int[4], 0, len);
        	
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
