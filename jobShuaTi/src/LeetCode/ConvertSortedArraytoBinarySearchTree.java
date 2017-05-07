package LeetCode;

public class ConvertSortedArraytoBinarySearchTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public class Solution {
		public TreeNode createTree(int[] nums, int start, int end){
			if (start>end){
				return null;
			}
			int midPos=(start+end)/2;
			TreeNode root=new TreeNode(nums[midPos]);
			if (start == end){
				return root;
			}
			root.left=createTree(nums, start, midPos-1);
			root.right=createTree(nums, midPos+1, end);
			return root;
		}
	    public TreeNode sortedArrayToBST(int[] nums) {
	    	if (nums.length==0){
	    		return null;
	    	}
	        return createTree(nums, 0, nums.length);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
