package LeetCode;

import java.util.Arrays;


public class ReversePairs493 {
	class TreeNode{
		long val;
		int Count;
		int dui;
		TreeNode left;
		TreeNode right;
		public TreeNode(long val) {
			// TODO Auto-generated constructor stub
			this.val=val;
			Count=0;
			dui=1;
		}
	}
	TreeNode root=null;
	public void createTree(Long i,TreeNode parent){
		if (i>parent.val){
			if (parent.right==null){
				parent.right=new TreeNode(i);
			}else{
			createTree(i, parent.right);
			}
			
		}else if (i<parent.val){
			parent.Count++;
			if(parent.left==null){
				parent.left=new TreeNode(i);
			}else{
			createTree(i, parent.left);
			}
		}else{
			parent.dui++;
		}
	}
	public int searchNode(long v,TreeNode root){
		if (root==null){
			return 0;
		}
		if (root.val==v){
			return root.Count;
		}else if (v>root.val){
			return root.Count+root.dui+searchNode(v, root.right);
		}else{
			return searchNode(v, root.left);
		}
	}
	public int reversePairs(int[] nums) {
		root=new TreeNode(nums[nums.length-1]*2);
		int res=0;
        for (int i=nums.length-2;i>=0;--i){
        	res+=searchNode(nums[i], root);
        	createTree((long)nums[i]*2, root);
        }
        return res;
    }
	
	
	public int reversePairs1(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
