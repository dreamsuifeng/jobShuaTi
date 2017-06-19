package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree623 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
public TreeNode addOneRow(TreeNode root, int v, int d) {
       Queue<TreeNode> q=new LinkedList<>();
       if (root==null) return new TreeNode(v);
       if (d==1){
    	   TreeNode t=new TreeNode(v);
    	   t.left=root;
    	   return t;
       }
       q.add(root);
       Queue<TreeNode> parent=new LinkedList<>();
       while (d>2 &&!q.isEmpty()){
    	   while(!q.isEmpty()){
    		   TreeNode tmp=q.poll();
    		   if (tmp.left!=null) parent.add(tmp.left);
        	   if (tmp.right!=null) parent.add(tmp.right);
    	   }
    	   parent.clear();
    	   q.addAll(parent);
    	   
    	   
       }
       while(!q.isEmpty()){
    	   TreeNode temp=q.poll();
    	   if (temp!=null){
    		   TreeNode l=temp.left;
    		   TreeNode r=temp.right;
    		   temp.left=new TreeNode(v);
    		   temp.right=new TreeNode(v);
    		   temp.left.left=l;
    		   temp.right.right=r;
    	   }
    	   
       }
       return root;
    }
}
