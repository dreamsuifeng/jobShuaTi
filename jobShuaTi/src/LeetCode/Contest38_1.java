package LeetCode;

import java.util.Arrays;

public class Contest38_1 {
	 public static int maximumProduct(int[] nums) {
		 	int n=nums.length;
	        Arrays.sort(nums);
	        if(nums[0]>=0){
	        	return nums[n-1]*nums[n-2]*nums[n-3];
	        }else if(nums[n-1]<=0){
	        	return nums[n-1]*nums[n-2]*nums[n-3];
	        }else{
	        	for (int i=0;i<n;++i){
	        		if (nums[i]>=0) break;
	        	}
	        	return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
