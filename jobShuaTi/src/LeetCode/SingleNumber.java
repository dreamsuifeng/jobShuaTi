package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        int res=nums[0];
        for (int i=1;i<nums.length;++i){
        	res^=nums[i];
        }
        return res;
    }
	public static int singleNumber1(int[] nums) {
        Map<Integer,Integer> set=new HashMap<>();
        for (int i=0;i<nums.length;++i){
        	if (!set.containsKey(nums[i])){
        		set.put(nums[i], 1);
        		}else if (set.get(nums[i])==2){
        		set.remove(nums[i]);
        	}else{
        		set.put(nums[i], set.get(nums[i])+1);
        	}
        }
        return set.keySet().iterator().next();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(singleNumber1(new int[]{2,1,2,1,2,1,3}));
		
	}

}
