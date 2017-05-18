package LeetCode;

public class MinimumSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
        int n=nums.length;
        if (n==0) return 0;
        if (n==1 && nums[0]<s) return 0;
        if (n==1 && nums[0]>s) return 1;
        int i=0,j=1;
        int len=Integer.MAX_VALUE;
        int currentSum=nums[0];
        boolean flag=false;
        while(i<n && j<n){
        	if (flag){
        		currentSum-=nums[i-1];
        		flag=false;
        	}else{
        		currentSum+=nums[j];
        	}
        	if (currentSum>=s){
        		len=len<j-i+1 ? len:j-i+1;
        		i++;
        		flag=true;
        	}else{
        		j++;
        	}
        }
        return len;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t={2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, t));
	}

}
