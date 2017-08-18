package LeetCode;

public class ArrayNesting565 {
	public int arrayNesting(int[] nums) {
		 int res = 0;
	    for (int i=0;i<nums.length;i++) {
	        if (nums[i] < 0) continue;
	        int length = 1, val = nums[i];
	        while (Math.abs(val) != i) {
	            length++;
	            val = nums[Math.abs(val)];
	            nums[Math.abs(val)] *= -1;
	        }
	        res = Math.max(res, length);
	    }
	        
	        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayNesting565 t=new ArrayNesting565();
		int[] input={5,4,0,3,1,6,2};
		System.out.println(t.arrayNesting(input));
	}

}
