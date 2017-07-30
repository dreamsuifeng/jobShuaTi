package LeetCode;

public class MaximumAverageSubarrayI643 {
	
	public static double findMaxAverage(int[] nums, int k) {
		int n=nums.length;
        int res=Integer.MIN_VALUE;
        int tmp=0;
        int i=0,j=0;
        while (i<k){
        		
        		tmp+=nums[i];
                i++;
        }
        while (i<n){
            res=Math.max(res, tmp);
            tmp-=nums[j];
            j++;
        	tmp+=nums[i];
        	i++;
        	
        	
        	
        }
        return res/(double)k;
    }
	public static void main(String[] args){
		int[] a={1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(a, 4));
	}
}
