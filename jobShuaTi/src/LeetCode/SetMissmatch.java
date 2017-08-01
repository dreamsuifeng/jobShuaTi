package LeetCode;

public class SetMissmatch {
	public int[] findErrorNums(int[] nums) {
		int[] dp=new int[nums.length];
		int[] res=new int[2];
		for (int i=0;i<nums.length;++i){
			if (dp[nums[i]-1]!=0){
				res[0]=nums[i];
			}
			dp[nums[i]-1]=1;
		}
		for (int i=0;i<nums.length;++i){
			if (dp[i]==0){
				res[1]=i+1;
				break;
			}
		}
		return res;
    }
}
