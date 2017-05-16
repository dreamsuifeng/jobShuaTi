package LeetCode;

import java.util.HashMap;

public class MajorityElement {
	public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=(n-1)/2+1;
        int res=-1;
        int countpre=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;++i){
            if (map.containsKey(nums[i])){
            	int tmp=map.get(nums[i]);
            	countpre=countpre<tmp+1 ? tmp+1:countpre;
            	res=countpre<tmp+1 ? nums[i]:res;
            	map.put(nums[i],tmp+1);
            }else{
            	map.put(nums[i], 1);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
