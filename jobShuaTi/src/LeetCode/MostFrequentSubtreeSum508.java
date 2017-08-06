package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum508 {
	
	public class TreeNode {
	 	      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	HashMap<Integer, Integer> map;
	private int search(TreeNode root){
		if (root==null) return 0;
		int left=search(root.left);
		int right=search(root.right);
		int sum=left+right+root.val;
		map.compute(sum, (k,v)->v==null ? 1:v+1);
		return sum;
	}
	public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        search(root);
        List<Integer> res=new LinkedList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();
        int max=Integer.MIN_VALUE;
        while (iterator.hasNext()){
        	Map.Entry<Integer, Integer> tmp=iterator.next();
        	if (tmp.getValue()==max){
        		res.add(tmp.getKey());
        	}else if (tmp.getValue()>max){
        		max=tmp.getValue();
        		res.clear();
        		res.add(tmp.getKey());
        	}
        }
        int[] ans=new int[res.size()];
        for (int i=0;i<res.size();++i){
        	ans[i]=res.get(i);
        	
        }
        return ans;
        
    }
	int maxDepth=Integer.MIN_VALUE;
	int value=0;
	private void searchlevel(TreeNode root,int level){
		if (root.left==null && root.right==null){
			if (level>maxDepth){
				maxDepth=level;
				value=root.val;
			}
		}
		if (root.left!=null) searchlevel(root.left, level+1);
		if (root.right!=null) searchlevel(root.right, level+1);
	}
	public int findBottomLeftValue(TreeNode root) {
        searchlevel(root, 0);
        return value;
    }
}	
