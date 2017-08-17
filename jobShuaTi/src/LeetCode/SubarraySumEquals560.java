package LeetCode;

import java.util.HashMap;

public class SubarraySumEquals560 {
	 public int subarraySum(int[] nums, int k) {
	        int ans=0;
	        int sum=0;
	        
	        HashMap<Integer, Integer> map=new HashMap<>();
	        map.put(0, 1);
	        for (int i=0;i<nums.length;++i){
	        	sum+=nums[i];
	        	if (map.containsKey(sum-k)){
	        		ans+=map.get(sum-k);
	        	}
	        	map.put(sum, map.getOrDefault(sum, 0)+1);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
