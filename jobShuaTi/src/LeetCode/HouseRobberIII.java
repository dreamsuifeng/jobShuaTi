package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseRobberIII {
	//Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  public int rob(TreeNode root) {
	        return solve(root, new HashMap<>());
	   }
	  public int solve(TreeNode root, Map<TreeNode, Integer> map){
		  if (root==null) return 0;
		  if(map.containsKey(root)){
			  return map.get(root);
		  }
		  int val=0;
		  if (root.left!=null){
			  val+=solve(root.left.left, map)+solve(root.left.right, map);
		  }
		  if (root.right!=null){
			  val+=solve(root.right.left, map)+solve(root.right.right,map);
		  }
		  val=Math.max(val+root.val, solve(root.left, map)+solve(root.right, map));
		  map.put(root, val);
		  return val;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
