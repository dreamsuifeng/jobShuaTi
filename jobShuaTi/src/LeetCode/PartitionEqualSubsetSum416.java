package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionEqualSubsetSum416 {
	public boolean canPartition(int[] nums) {
		int sum=0;
        for (int i:nums){
        	sum+=i;
        }
        if (sum%2!=0) return false;
        boolean[][] dp=new boolean[nums.length][sum/2+1];
        dp[0][nums[0]]=true;
        for (int i=1;i<nums.length;++i){
        	if (nums[i]<=sum/2){
        		dp[i][nums[i]]=true;
        	}
        	for (int j=0;j<sum/2;++j){
        		if(j+nums[i]<=sum/2){
        			dp[i][j+nums[i]]=true;
        		}
        	}
        	if (dp[i][sum/2]) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<>();
	}

}
