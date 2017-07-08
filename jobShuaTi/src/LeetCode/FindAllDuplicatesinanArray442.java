package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesinanArray442 {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;++i){
        	int index=Math.abs(nums[i])-1;
        	if(nums[index]<0){
        		res.add(index+1);
        	}
        	nums[index]=-nums[index];
        }
        return res;
    }
	 public List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> res=new ArrayList<>();
	        for (int i=0;i<nums.length;++i){
	            int index=Math.abs(nums[i])-1;
	            if (nums[index]<0) continue;
	            nums[index]=-nums[index];
	        }
	        for (int i=0;i<nums.length;++i){
	            if (nums[i]>0) res.add(i+1);
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
