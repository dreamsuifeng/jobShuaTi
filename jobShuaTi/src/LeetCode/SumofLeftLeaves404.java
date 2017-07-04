package LeetCode;
public class SumofLeftLeaves404 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	 public int sumOfLeftLeaves(TreeNode root) {
		 if(root == null) return 0;
		    int ans = 0;
		    if(root.left != null) {
		        if(root.left.left == null && root.left.right == null) ans += root.left.val;
		        else ans += sumOfLeftLeaves(root.left);
		    }
		    ans += sumOfLeftLeaves(root.right);
		    
		    return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
