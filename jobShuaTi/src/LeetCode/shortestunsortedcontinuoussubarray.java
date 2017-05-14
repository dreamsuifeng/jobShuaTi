package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.xml.transform.Templates;

public class shortestunsortedcontinuoussubarray {
	class TreeNode{
		private int ppid;
		
		public TreeNode(int p) {
			ppid=p;
			// TODO Auto-generated constructor stub
		}
		List<TreeNode> child=new LinkedList<>();
		List<Integer> cildPorcess= new LinkedList<>();
	}
	private TreeNode root=null;
	Map<Integer, TreeNode> map=new HashMap<>();
	public void createTree(List<Integer> pid, List<Integer> ppid, int kill){
		
		int n=pid.size();
		for (int i=0;i<n;++i){
			TreeNode temp=null;
			if (!map.containsKey(pid.get(i))){
				temp=new TreeNode(pid.get(i));
				map.put(pid.get(i), temp);
			}else {
				temp=map.get(pid.get(i));
			}
			TreeNode pTemp=null;
			if (ppid.get(i)==0){
				root=temp;
			}
			else if (!map.containsKey(ppid.get(i))){
				pTemp=new TreeNode(ppid.get(i));
			}else{
				pTemp=map.get(ppid.get(i));
			}
			pTemp.child.add(temp);
			pTemp.cildPorcess.add(pid.get(i));
		}
	}
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	        createTree(pid, ppid, kill);
	        List<Integer> res=new LinkedList<>();
	        Queue<TreeNode> temp=new LinkedList<>();
	        res.add(kill);
	        temp.add(map.get(kill));
	        while (!temp.isEmpty()){
	        	TreeNode qtemp=temp.poll();
	        	res.addAll(qtemp.cildPorcess);
	        	temp.addAll(qtemp.child);
	        }
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
