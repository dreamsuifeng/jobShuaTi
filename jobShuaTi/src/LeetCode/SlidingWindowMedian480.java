package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SlidingWindowMedian480 {
	 public double[] medianSlidingWindow(int[] nums, int k) {
		 int n=nums.length;
		 double[] res=new double[n-k+1];
		 ArrayList<Integer> help=new ArrayList<>();
		 for (int i=0;i<k;++i){
			 help.add(nums[i]);
		 }
		 Collections.sort(help);
		 int i=k;
		 for (i=k;i<n;++i){
			 if (k%2==0){
				 res[i-k]=((long)help.get(k/2)+(long)help.get(k/2-1))/2;
			 }else{
				 res[i-k]=help.get(k/2);
			 }
			 int index=Collections.binarySearch(help, nums[i-k]);
			 help.remove(index);
			 int index2=Collections.binarySearch(help, nums[i]);
			 help.add(index2, nums[i]);
		 }
		 if (k%2==0){
			 res[i-k]=(help.get(k/2)+help.get(k/2-1))/2;
		 }else{
			 res[i-k]=help.get(k/2);
		 }
	     return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
