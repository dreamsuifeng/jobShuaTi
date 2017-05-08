package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public class Solution {
	    private int maxSum=Integer.MIN_VALUE;
	    public int maxPath(TreeNode root, int h) {
	        if (root.left==null && root.right==null){
	            if (root.val>maxSum) maxSum=root.val;
	            return root.val;
	        }
	        int leftSum=Integer.MIN_VALUE,rightSum=Integer.MIN_VALUE,rootSum=Integer.MIN_VALUE;
	        if (root.left!=null) leftSum=maxPath(root.left,h+1);
	        if (root.right!=null) rightSum=maxPath(root.right,h+1);
	        int temp=leftSum>rightSum ? leftSum:rightSum;
	        if(temp>maxSum) maxSum=temp;
	        if(temp+root.val>maxSum) maxSum=temp+root.val;
	        if(root.val>maxSum) maxSum=root.val;
	        if(leftSum!=Integer.MIN_VALUE && rightSum!=Integer.MIN_VALUE && leftSum+rightSum+root.val>maxSum) maxSum=leftSum+rightSum+root.val;
	        return temp+root.val>root.val ? temp+root.val:root.val;
	    }
	    public int maxPathSum(TreeNode root){
	        maxPath(root,1);
	        return maxSum;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
