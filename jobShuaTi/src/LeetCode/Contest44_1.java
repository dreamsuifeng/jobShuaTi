package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.reflect.generics.tree.Tree;
import sun.tools.jar.resources.jar;

public class Contest44_1 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private List<Integer> data=new ArrayList<>();
	private void search(TreeNode root){
		if (root==null) return;
		search(root.left);
		data.add(root.val);
		search(root.right);
	}
	private boolean isTrue(int k){
		Collections.sort(data);
		if (k<data.get(0)) return false;
		int n=data.size()-1;
		int i=0;
		int sum=data.get(i)+data.get(n);
		while(i<n){
			if (sum==k) return true;
			if (sum>k) i++;
			else n--;
		}
		return false;
	}
public boolean findTarget(TreeNode root, int k) {
        search(root);
        return isTrue(k);
    }
	
	private void createTree(int[] nums, int left, int right,TreeNode par,boolean flag){
		if (left<right) return;
		int maxindex=-1;
		int maxvalue=Integer.MIN_VALUE;
		for (int i=left;i<=right;++i){
			if (nums[i]>maxvalue){
				maxvalue=nums[i];
				maxindex=i;
				break;
			}
		}
		TreeNode t=new TreeNode(maxvalue);
		if (flag) par.left=t;
		else par.right=t;
		createTree(nums, left, maxindex-1, t, flag);
		createTree(nums, maxindex+1, right, t, !flag);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root=new TreeNode(-1);
		createTree(nums, 0, nums.length-1, root, true);
		return root.left;
	}
	
	
	public List<Integer> cheapestJump(int[] A, int B) {
        int n=A.length;
        long[] dp=new long[n];
        int[] path=new int[n];
        Arrays.fill(path, -1);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1]=0;
        for (int i=n-2;i>=0;--i){
        	if (A[i]==-1) continue;
        	for (int k=1;k<=B && i+k<n;++k){
        		if (A[i+k]<0) continue;
    			if (A[i]+dp[i+k]<dp[i]){
    				dp[i]=dp[i+k]+A[i];
    				path[i]=i+k;
    			}
        		
        	}
        }
        List<Integer> res=new LinkedList<>();
        if (dp[0]==Integer.MAX_VALUE) return res;
        res.add(1);
        int j=0;
        while (j!=n-1){
        	res.add(path[j]+1);
        	j=path[j];
        }
        return res;
    }
	
	
	public List<List<String>> printTree(TreeNode root) {
	    List<List<String>> res = new LinkedList<>();
	    int height = root == null ? 1 : getHeight(root);
	    int rows = height, columns = (int) (Math.pow(2, height) - 1);
	    List<String> row = new ArrayList<>();
	    for(int i = 0; i < columns; i++)  row.add("");
	    for(int i = 0; i < rows; i++)  res.add(new ArrayList<>(row));
	    populateRes(root, res, 0, rows, 0, columns - 1);
	    return res;
	}

	public void populateRes(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
	    if (row == totalRows || root == null) return;
	    res.get(row).set((i+j)/2, Integer.toString(root.val));
	    populateRes(root.left, res, row+1, totalRows, i, (i+j)/2 - 1);
	    populateRes(root.right, res, row+1, totalRows, (i+j)/2+1, j);
	}

	public int getHeight(TreeNode root) {
	     if (root == null) return 0;
	     return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
