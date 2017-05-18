package LeetCode;

public class HouseRobber {
//	public int findMax(int[] nums, int start, int end){
//		int res=0;
//		if (start>end){
//			return 0;
//		}
//		if (start==end){
//			return nums[start];
//		}
//		
//		int index=-1;
//		for (int i=start;i<=end;++i){
//			if (nums[i]>res){
//				res=nums[i];
//				index=i;
//			}
//		}
////		System.out.println(res);
//		return res+findMax(nums, start, index-2)+findMax(nums, index+2, end);
//	}
	public int rob(int[] nums) {
		int n = nums.length;
        if(n == 0) return 0;
        if(n ==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        int max= dp[1];
        for(int i = 2; i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber t=new HouseRobber();
		int[] test=new int[]{5,4,6,3,1,2};
		System.out.println(t.rob(test));
	}

}
