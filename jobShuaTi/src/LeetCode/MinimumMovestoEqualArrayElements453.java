package LeetCode;

import java.util.stream.IntStream;

public class MinimumMovestoEqualArrayElements453 {
	public static int minMoves(int[] nums) {
        if (nums.length==1) return 0;
        long sum=0;
        int max=0;
        for (int i:nums){
            sum+=i;
            max=Math.max(max,i);
        }
        long start=((long)max)*nums.length;
        long diff=start-sum;
        while (diff%(nums.length-1)!=0){
            diff+=nums.length;
        }
        return IntStream.of(nums).sum() - nums.length * IntStream.of(nums).min().getAsInt();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minMoves(new int[]{1,1,2147483647}));
	}

}
