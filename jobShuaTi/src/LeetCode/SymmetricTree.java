package LeetCode;
import java.lang.Math;
import java.util.ArrayList;

public class SymmetricTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public class Solution {
		private ArrayList<String> data=new ArrayList<String>();
		public void InOrder(TreeNode root){
			if(root.left!=null){
				InOrder(root.left);
			}else if (root.left==null && root.right!=null){
				data.add("null");
			}
			data.add(Integer.toString(root.val));
			if (root.right!=null){
				InOrder(root.right);
			}else if(root.right==null && root.left!=null){
				data.add("null");
			}
			
		}
		public boolean isSymmetric(TreeNode root) {
			if (root==null){
				return true;
			}
	         InOrder(root);
	         for (int i=0;i<data.size();++i){
	        	 System.out.println(data.get(i));
	         }
	         int i=0;
	         int j=data.size()-1;
	         while(i<j){
	        	 if (data.get(i).equals(data.get(j))==false){
	        		 return false;
	        	 }else{
	        		 ++i;
	        		 --j;
	        	 }
	         }
	         return true;
	         
		}
		
	}
	public static void main(String[] args) {
//		Math.max(a, b);
		// TODO Auto-generated method stub

	}

}
