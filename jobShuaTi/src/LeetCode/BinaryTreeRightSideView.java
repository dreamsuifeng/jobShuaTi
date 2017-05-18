package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private List<Integer> res=new LinkedList<>();
	private void righview(TreeNode root){
		if (root==null) return;
		Queue<TreeNode> queue=new LinkedList<>();
		Queue<TreeNode> queue2=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			while (!queue.isEmpty()){
				TreeNode tmp=queue.poll();
				if (tmp.left!=null) queue2.add(tmp.left);
				if (tmp.right!=null) queue2.add(tmp.right);
				if (queue.isEmpty()){
					res.add(tmp.val);
				}
			}
				while (!queue2.isEmpty()){
					TreeNode tmp2=queue2.poll();
					if (tmp2.left!=null) queue.add(tmp2.left);
					if (tmp2.right!=null) queue.add(tmp2.right);
					if (queue2.isEmpty()){
						res.add(tmp2.val);
					}
				}
			}
	}
	public List<Integer> rightSideView(TreeNode root) {
        righview(root);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
