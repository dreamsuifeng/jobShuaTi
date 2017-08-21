package XiaoZhao;

import java.util.Scanner;

public class Lianjia31 {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while(in.hasNext()) {
	            int n = in.nextInt();
	            int[] nums = new int[n];
	            for(int i = 0; i < n; ++i) {
	                nums[i] = in.nextInt();
	            }
	            int zero = 0, two = nums.length - 1;
	            int res = 0;
	            for(int i = 0; i <= two; ++i) {
	                while(nums[i] == 3 && i < two) {
	                    swap(nums, i, two--);
	                    ++res;
	                }
	                while(nums[i] == 1 && i > zero) {
	                    swap(nums, i, zero++);
	                    ++res;
	                }
	            }
	            System.out.println(res-1);
	        }
	    }

	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }


}
