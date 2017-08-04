package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import hihoCoder.interSum;

public class FindModeinBinarySearchTree501 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private Map<Integer, Integer> map;
	public void search(TreeNode root){
		if (root==null) return;
		if (map.containsKey(root.val)){
			map.put(root.val,map.get(root.val)+1);
		}else{
			map.put(root.val, 1);
		}
		search(root.left);
		search(root.right);
	}
	public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        search(root);
        PriorityQueue<int[]> priq=new PriorityQueue<>((x,y)->y[1]-x[1]);
        Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
        	int[] t=new int[2];
        	Map.Entry<Integer, Integer> tmp=it.next();
        	t[0]=tmp.getKey();
        	t[1]=tmp.getValue();
        	priq.add(t);
        }
        int max=priq.peek()[1];
        List<Integer> res=new LinkedList<>();
        while (!priq.isEmpty()){
        	if (priq.peek()[1]<max){
        		break;
        	}
        	res.add(priq.peek()[0]);
        	priq.poll();
        }
        int[] ans=new int[res.size()];
        for (int i=0;i<res.size();++i){
        	ans[i]=res.get(i);
        }
        return ans;
     }
}
