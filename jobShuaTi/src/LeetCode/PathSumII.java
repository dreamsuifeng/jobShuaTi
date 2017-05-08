package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public class Solution {
	    private List<List<Integer>> result=new ArrayList<List<Integer>>();
	    private List<Integer> temp=new ArrayList<Integer>();
	    public void findPathSum(TreeNode root, int sum){
	    	System.out.println(temp.size());
	        if (root==null){
	            return;
	        }
	        temp.add(root.val);
	        if (root.left==null && root.right==null && sum==root.val){
	        	List<Integer> tmp=new ArrayList<Integer>();
	        	for (Integer integer : temp) {
					tmp.add(integer);
				}
	        	result.add(tmp);
	        	temp.remove(temp.size()-1);
	            return;
	        }else if (root.left==null && root.right==null && sum!=root.val){
	        	temp.remove(temp.size()-1);
	            return;
	        }else{
	            findPathSum(root.left,sum-root.val);
	            findPathSum(root.right,sum-root.val);
	        }
	    }
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        findPathSum(root, sum);
	        return result;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
