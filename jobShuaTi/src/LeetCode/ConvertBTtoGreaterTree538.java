package LeetCode;

public class ConvertBTtoGreaterTree538 {
	public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	int sum=0;
	 public void convert(TreeNode cur) {
	        if (cur == null) return;
	        convert(cur.right);
	        cur.val += sum;
	        sum = cur.val;
	        convert(cur.left);
	    }
	public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
	
}
