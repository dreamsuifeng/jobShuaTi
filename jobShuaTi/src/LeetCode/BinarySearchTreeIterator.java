package LeetCode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private TreeNode root;
	private Queue<Integer> queue=null;
	public void BSTIterator(TreeNode root) {
        this.root=root;
        queue=new LinkedList<>();
        Inorder(this.root);
        
    }
	private void Inorder(TreeNode root){
		if (root==null) return;
		Inorder(root.left);
		queue.add(root.val);
		Inorder(root.right);
		
	}

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
