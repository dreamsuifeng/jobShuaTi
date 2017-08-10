package LeetCode;

import java.util.Arrays;

public class KdiffPairsanArray532 {
	public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=1;
        int ans=0;
        while (i<nums.length && j<nums.length){
        	if (i>0 && nums[i]==nums[i-1]) {
        		i++;
//        		j++;
        		continue;
        		}
        	while (j<nums.length && nums[j]-nums[i]<k) j++;
        	if (j==i) j++;
        	if (j<nums.length && j>i && nums[j]-nums[i]==k) {
        		ans++;
        		i++;
        		j++;
        	}else{
        		i++;
//        		j++;
        	}
        	
        }
        return ans;
        
    }
	public static void main(String[] args){
		int[] nums={1,1,1,2,2};
		System.out.println(findPairs(nums, 0));
	}
}
