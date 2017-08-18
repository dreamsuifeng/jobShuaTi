package LeetCode;

public class BinaryTreeTilt563 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private int ans=0;
	public int findSum(TreeNode root) {
        if (root==null) return 0;
        int left=findSum(root.left);
        int right=findSum(root.right);
        ans=ans+Math.abs(left-right);
        return left+right+root.val;
    }
public int findTilt(TreeNode root) {
     findSum(root);
     return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
