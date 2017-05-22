package LeetCode;

import java.util.Arrays;

public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
