package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Contest40 {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<Double>();
        LinkedList<TreeNode> q1=new LinkedList<>();
        LinkedList<TreeNode> q2=new LinkedList<>();
        if (root==null) return res;
        q1.add(root);
        while(!q1.isEmpty()){
        	double mean=0.0;
        	int count=0;
	        while (!q1.isEmpty()){
	        	TreeNode t=q1.poll();
	        	count++;
	        	mean+=t.val;
	        	if (t.left!=null) q2.add(t.left);
	        	if (t.right!=null) q2.add(t.right);
	        }
	        if (count>0) res.add(mean/count);
	        q1.addAll(q2);
	        q2.clear();
        }
	    return res;   
    }
	public static void main(String[] args) {
		System.out.println("test");
	}

}
