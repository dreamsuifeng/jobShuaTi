package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;++i){
        	if (map.containsKey(nums[i]) && i-map.get(nums[i])<=k){
        		return true;
        	}else{
        		map.put(nums[i], i);
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set= new TreeSet<>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(4);
		set.add(8);
		set.add(10);
		set.add(5);
		set.add(6);
		set.add(9);
		set.add(7);
		set.add(11);
		set.add(0);
		System.out.println(set.ceiling(8));
		System.out.println(set.floor(12));
	}

}
