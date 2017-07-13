package LeetCode;

import java.util.Stack;

public class Pattern132_456 {
	public boolean find132pattern(int[] nums) {
        if(nums==null || nums.length<3) return false;
        Stack<int[]> stack=new Stack<>();
        for (int i:nums){
        	if(stack.isEmpty() || i<stack.peek()[0]){
        		int[] t=new int[2];
        		t[0]=i;
        		t[1]=i;
        		stack.push(t);
        	}else if (i>stack.peek()[0]){
        		int[] t=stack.pop();
        		if (t[1]>i) return true;
        		else{
        			t[1]=i;
        			while (!stack.isEmpty() && i>=stack.peek()[1]) stack.pop();
        			if (!stack.isEmpty() && stack.peek()[0]<i) return true;
        			stack.push(t);
        		}
        	}
        }
        return false;
    }	
}
