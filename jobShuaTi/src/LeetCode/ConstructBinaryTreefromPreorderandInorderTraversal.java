package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public class Solution {
	    public TreeNode createSubTree(int preBegin, int preEnd, int[] preorder, int inBegin, int inEnd, int[] inorder){
	    	TreeNode root=new TreeNode(preorder[preBegin]);
	    	if (preBegin==preEnd){
	    		return root;
	    	}
	    	if (preBegin>preEnd){
	    		return null;
	    	}
	    	int pos=-1;
	    	for(int i=inBegin;i<inEnd;++i){
	    		if (inorder[i]==preorder[preBegin]){
	    			pos=i;
	    			break;
	    		}
	    	}
	    	root.left=createSubTree(preBegin+1,preBegin+pos-inBegin, preorder, inBegin, pos-1, inorder);
	    	root.right=createSubTree(preBegin+pos-inBegin+1, preEnd, preorder, pos+1, inEnd, inorder);
	    	return root;
	    }
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	return createSubTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
	        
	    }
	}
}
