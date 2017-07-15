package LeetCode;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements462 {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
        int mid=nums[nums.length/2];
        int count=0;
        for (int i=0;i<nums.length;++i){
        	count+=Math.abs(mid-nums[i]);
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
