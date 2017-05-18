package LeetCode;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        int n=nums.length;
        if (k==0) return;
        int i=0;
        while(i<n-k){
        	int j=n-k;
        	while (j<n){
	        	int tmp=nums[i];
	        	nums[i]=nums[j];
	        	nums[j]=tmp;
	        	j++;
	        	i++;
        	}
        }
    }
	public static void main(String[] args){
		
	}
}
