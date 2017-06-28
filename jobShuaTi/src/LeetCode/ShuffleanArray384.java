package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ShuffleanArray384 {
	int[] ori;
	Random rd;
	List<Integer> ay;
	public ShuffleanArray384(int[] nums) {
        rd=new Random();
        ori=Arrays.copyOf(nums, nums.length);
        ay=new ArrayList<>();
        for (int i:nums){
        	ay.add(i);
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] naary=new int[ori.length];
        List<Integer> copy=new ArrayList<>(ay);
        for (int i=0;i<ori.length;++i){
        	int idn=rd.nextInt(copy.size());
        	naary[i]=copy.get(idn);
        	copy.remove(idn);
        }
        return naary;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
