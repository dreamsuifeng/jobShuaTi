package LeetCode;

public class ValidTriangleNumber {
	public int triangleNumber(int[] nums) {
        int n=nums.length;
        int res=0;
        if (n<3) return 0;
        for (int i=2;i<n;++i){
        	int left=0, right=i-1;
        	while (left<right){
        		if (left+right>nums[i]){
        			res+=(right-left);
        			right--;
        		}else {
					left++;
				}
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
