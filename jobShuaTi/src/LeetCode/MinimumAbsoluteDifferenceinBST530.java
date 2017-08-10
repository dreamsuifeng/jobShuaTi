package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST530 {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	List<Integer> list=new ArrayList<>();
	public void inorder(TreeNode root){
		if (root==null) return;
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
	private int ans=Integer.MAX_VALUE;
	public void inorderCompute(TreeNode root, TreeNode preNode){
		if (root==null) return;
		inorderCompute(root.left,preNode);
		if (preNode!=null){
			int absval=Math.abs(preNode.val-root.val);
			if (absval<ans) ans=absval;
		}
		preNode=root;
		inorderCompute(root.right, preNode);
		
	}
	public int getMinimumDifference(TreeNode root) {
		inorderCompute(root,null);
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
