package hihoCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hiho20_3 {
	public static String solve(HashMap<Integer, List<Integer>> edges,int root){
		if (!edges.containsKey(root)) return "1";
		List<Integer> childsroot=edges.get(root);
		if (childsroot.size()%2==0){
			int count=0;
			for (int child:childsroot){
				if (!edges.containsKey(child)) count++;
				
			}
			if (count%2!=0) return "1";
			else return "0";
		}else{
			return "1";
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int Q=in.nextInt();
		Set<Integer> froms=new HashSet<>();
		Set<Integer> ends=new HashSet<>();
		StringBuffer res=new StringBuffer();
		for (int i=0;i<Q;++i){
			int n=in.nextInt();
			HashMap<Integer, List<Integer>> edges=new HashMap<>();
			for (int j=0;j<n-1;++j){
				int from=in.nextInt();
				int end=in.nextInt();
				froms.add(from);
				ends.add(end);
				if (edges.containsKey(from)){
					edges.get(from).add(end);
				}else{
					List<Integer> tmp=new LinkedList<>();
					tmp.add(end);
					edges.put(from, tmp);
				}
			}
			int root=-1;
			Iterator<Integer> it=froms.iterator();
			while (it.hasNext()){
				int t=it.next();
				if (!ends.contains(t)){
					root=t;
					break;
				}
			}
			List<Integer> childsroot=edges.get(root);
			res.append(solve(edges, root));
			boolean flag=true;
			for (int child:childsroot){
				if (solve(edges, child).equals("0")){
					res.append("0");
					flag=false;
					break;
				}
			}
			if (flag){
				res.append("1");
			}
			
			
			
			
			
	}
		System.out.println(res.toString());
	}
}
