package LeetCode;

public class sumRoottoLeafNumbers {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private int res=0;
    public void sumNumbers1(TreeNode root, int sum) {
        if (root.left==null && root.right==null){
        	res+=sum+root.val;
        }
        
        if (root.left!=null) { sumNumbers1(root.left,(sum+root.val)*10);}
        if (root.right!=null) { sumNumbers1(root.right,(sum+root.val)*10);}
    }
    public int sumNumbers(TreeNode root){
        if (root==null) return 0;
        sumNumbers1(root,0);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
