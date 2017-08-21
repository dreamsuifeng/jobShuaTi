package LeetCode;

public class Contest46_3 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	class newTreeNode{
		int val;
		int allsum;
		int leftsum;
		int rightsum;
		newTreeNode left;
		newTreeNode right;
		
	}
	private boolean flag=false;
	public void trip(newTreeNode root,int cur){
		if (root==null) return;
		if (cur==root.allsum) flag=true;
		if (root.left!=null){
			trip(root.left, cur+root.rightsum+root.val);
		}
		if (root.right!=null){
			trip(root.right, cur+root.leftsum+root.val);
		}
	}
	public newTreeNode findSum(TreeNode root){
		if (root==null) return null;
		newTreeNode lefts=findSum(root.left);
		newTreeNode right=findSum(root.right);
		newTreeNode nTNode=new newTreeNode();
		nTNode.left=lefts;
		nTNode.right=right;
		nTNode.val=root.val;
		nTNode.allsum=(lefts!=null? lefts.allsum:0)+(right!=null ? right.allsum:0)+root.val;
		nTNode.leftsum=lefts!=null ? lefts.allsum:0;
		nTNode.rightsum=right!=null ? right.allsum:0;
		return nTNode;
	}
	public boolean checkEqualTree(TreeNode root) {
		newTreeNode ro=findSum(root);
		trip(ro, 0);
		return flag;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
