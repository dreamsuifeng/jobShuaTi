package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if (root==null) return res;
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        Queue<TreeNode> tmp=new LinkedList<>();
        while (!q1.isEmpty()){
	        int max=Integer.MIN_VALUE;
	        while (!q1.isEmpty()){
	        	TreeNode t=q1.poll();
	        	max=Math.max(max, t.val);
	        	if (t.left!=null) tmp.add(t.left);
	        	if (t.right!=null) tmp.add(t.right);
	        	
	        }
	        res.add(max);
	        q1.addAll(tmp);
	        tmp.clear();
        }
        return res;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
