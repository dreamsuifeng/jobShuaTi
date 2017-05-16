package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class MaximumGap {
	public int maximumGap(int[] nums) {
        int n=nums.length;
        if (n<2) return 0;
        Arrays.sort(nums);
        int res=0;
        for (int i=0;i<n-1;++i){
        	int tmp=Math.abs(nums[i+1]-nums[i]);
        	res = res<tmp ? tmp:res;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
