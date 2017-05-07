package LeetCode;

import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
//import java.lang.reflect.Array;
//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		public class Solution {
		    public List<List<Integer>> levelOrder(TreeNode root) {
		        LinkedList<List<Integer>> result=new LinkedList<List<Integer>>();
		        if (root==null){
		            return result;
		        }
		        LinkedList<TreeNode> stack2=new LinkedList<TreeNode>();
		        LinkedList<TreeNode> stack1=new LinkedList<TreeNode>();
		        stack1.add(root);
		        
		        while(stack1.isEmpty()==false || stack2.isEmpty()==false){
		        	ArrayList<Integer> leveTemp1=new ArrayList<Integer>();
			        ArrayList<Integer> leveTemp2=new ArrayList<Integer>();
			        while(stack1.isEmpty()==false){
			        	TreeNode temp=stack1.getLast();
			        	leveTemp1.add(temp.val);
			        	if (temp.left!=null){
			        		stack2.add(temp.left);
			        	}
			        	if (temp.right!=null){
			        		stack2.add(temp.right);		        		
			        	}
			        }
			        if(leveTemp1.isEmpty()==false){
			        	result.add(leveTemp1);
			        }
//			        leveTemp1.clear();
			       while(stack2.isEmpty()==false){
			    	   TreeNode temp2=stack2.getLast();
			    	   leveTemp2.add(temp2.val);
			    	   if (temp2.right!=null){
			    		   stack1.add(temp2.right);
			    	   }
			    	   if (temp2.left!=null){
			    		   stack1.add(temp2.left);
			    	   }
			    	   
			       }
			       if(leveTemp2.isEmpty()==false){
			        	result.add(leveTemp2);
			        }
//			       leveTemp2.clear();
			     }
			        return result;
		    }
		    
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
