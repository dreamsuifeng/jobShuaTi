package LeetCode;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
        int res=nums[0];
        int maxPre=nums[0];
        int minPre=nums[0];
        int maxhere,minhere;
        
        for (int i=1;i<nums.length;++i){
            maxhere=Math.max(Math.max(maxPre*nums[i],minPre*nums[i]),nums[i]);
            minhere=Math.min(Math.min(maxPre*nums[i],minPre*nums[i]),nums[i]);
            res=Math.max(maxhere,res);
            maxPre=maxhere;
            minPre=minhere;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"ab".charAt(index);
	}

}
