package LeetCode;

import java.util.Stack;

public class NextGreaterElementII503 {
	public int[] nextGreaterElements(int[] nums) {
		if (nums==null || nums.length==0) return new int[0];
        int n=nums.length;
        int[] ans=new int[n];
        Stack<int[]> s=new Stack<>();
        int[] t=new int[2];
        t[0]=0;
        t[1]=nums[0];
        s.add(t);
        for (int i=1;i<n;++i){
        	while(s.size()>0 && nums[i]>s.peek()[1]){
        		ans[s.peek()[0]]=nums[i];
        		s.pop();
        	}
        	int[] tmp=new int[2];
        	tmp[0]=i;
        	tmp[1]=nums[i];
        	s.add(tmp);
        }
        // System.out.println(s.size());
       if (s.size()>1){
    	   for (int i=0;i<n;++i){
           	while(nums[i]>s.peek()[1]){
           		ans[s.peek()[0]]=nums[i];
           		s.pop();
           	}
           	if (s.size()==1){
           		break;
           	}
           }
       }
       while (!s.isEmpty()){
    	   ans[s.peek()[0]]=-1;
    	   s.pop();
       }
       
       return ans;
    }
	public class Solution {
	    public int nextGreaterElement(int n) {
	        char[] a=(""+n).toCharArray();
	        int i = a.length - 2;
	        while (i >= 0 && a[i + 1] <= a[i]) {
	            i--;
	        }
	        if(i<0)
	            return -1;
	        int j = a.length - 1;
	        while (j >= 0 && a[j] <= a[i]) {
	            j--;
	        }
	        swap(a, i, j);
	        reverse(a, i + 1);
	        try{
	           return Integer.parseInt(new String(a));
	        }
	        catch(Exception e){
	           return -1;
	        }
	    }
	    private void reverse(char[] a, int start) {
	        int i = start, j = a.length - 1;
	        while (i < j) {
	            swap(a, i, j);
	            i++;
	            j--;
	        }
	    }
	    private void swap(char[] a, int i, int j) {
	        char temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer.toString(10, 7);
	}

}
