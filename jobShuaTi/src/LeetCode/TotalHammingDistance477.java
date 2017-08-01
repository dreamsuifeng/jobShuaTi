package LeetCode;

public class TotalHammingDistance477 {
	public int totalHammingDistance(int[] nums) {
		int res=0;
        for (int j=0;j<32;++j){
        	int count=0;
        	for (int i=0;i<nums.length;++i){
        		count+=((nums[i]>>j)&1);
        	}
        	res=res+count*(nums.length-count);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
