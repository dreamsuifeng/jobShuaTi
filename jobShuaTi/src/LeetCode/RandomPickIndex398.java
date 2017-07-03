package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomPickIndex398 {
	private int[] num;
	HashMap<Integer, ArrayList<Integer>> map;
 	public RandomPickIndex398(int[] nums) {
	        this.num=nums;
	        map=new HashMap<>();
	        for (int i=0;i<nums.length;++i){
	        	if (map.containsKey(nums[i])){
	        		map.get(nums[i]).add(i);
	        	}else{
	        		ArrayList<Integer> tmp=new ArrayList<>();
	        		tmp.add(i);
	        		map.put(nums[i], tmp);
	        	}
	        }
	    }
	    
    public int pick(int target) {
	        int size=map.get(target).size();
	        Random r=new Random();
	        return map.get(target).get(r.nextInt(size));
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
