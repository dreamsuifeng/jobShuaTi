package LeetCode;

public class RecoverBinarySearchTree {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	 public class Solution {
		    
		    TreeNode firstElement = null;
		    TreeNode secondElement = null;
		    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
		    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
		    
		    public void recoverTree(TreeNode root) {
		        
		        // In order traversal to find the two elements
		        traverse(root);
		        
		        // Swap the values of the two nodes
		        int temp = firstElement.val;
		        firstElement.val = secondElement.val;
		        secondElement.val = temp;
		    }
		    
		    private void traverse(TreeNode root) {
		        
		        if (root == null)
		            return;
		            
		        traverse(root.left);
		        
		   
		        if (firstElement == null && prevElement.val >= root.val) {
		            firstElement = prevElement;
		        }
		    
		       
		        if (firstElement != null && prevElement.val >= root.val) {
		            secondElement = root;
		        }        
		        prevElement = root;



		        traverse(root.right);
		}
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
