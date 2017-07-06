package LeetCode;

import java.util.LinkedList;

public class MaximumXORofTwoNumbersinanArray421 {
	class TreeNode{
		TreeNode[] child;
		public TreeNode(){
			child=new TreeNode[2];
		}
	}
	public void add(int x,TreeNode root){
        TreeNode p=root;
		for (int i=0;i<32;++i){
			int bit=(x>>i)&1;
			if(p.child[bit]==null) p.child[bit] = new TreeNode();
			p=p.child[bit];
		}
	}
	public int search(int x, TreeNode root){
		int ans=0;
        TreeNode p=root;
		for (int i=0;i<32;++i){
			int bit=(x>>i)&1;
			if (p.child[bit^1]!=null){
				ans+=(1<<i);
				p=p.child[bit^1];
			}else{
				p=p.child[bit];
			}
		}
        // System.out.println(ans);
		return ans;
			
	}
	public int findMaximumXOR(int[] nums) {
       TreeNode root=new TreeNode();
       for (int i=0;i<nums.length;++i){
    	   add(nums[i], root);
       }
       int ans=0;
       for(int i=0;i<nums.length;++i){
    	   ans=Math.max(ans, search(nums[i], root));
       }
       return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((-((~5)-1)));
	}

}
