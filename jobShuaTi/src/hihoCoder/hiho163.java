package hihoCoder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class hiho163 {
	private static void dfs(HashMap<Integer, List<Integer>> edges, boolean[] used, int cur){
		used[cur-1]=true;
		List<Integer> childs=edges.get(cur);
		for (int child:childs){
			if (!used[child-1]){
				dfs(edges, used, child);
			}
		}
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		List<String> reStrings=new LinkedList<>();
		for (int i=0;i<T;++i){
			int N=in.nextInt();
			int M=in.nextInt();
			HashMap<Integer, List<Integer>> edges=new HashMap<>();
			for (int j=0;j<M;++j){
				int from=in.nextInt();
				int end=in.nextInt();
				if (edges.containsKey(from)){
					edges.get(from).add(end);
				}else{
					List<Integer> tmp=new LinkedList<>();
					tmp.add(end);
					edges.put(from, tmp);
				}
				if (edges.containsKey(end)){
					edges.get(end).add(from);
				}else{
					List<Integer> tmp=new LinkedList<>();
					tmp.add(from);
					edges.put(end, tmp);
				}
			}
			if (N!=M+1){
				reStrings.add("NO");
			}else{
				boolean[] used=new boolean[N];
				dfs(edges, used, 1);
				boolean flag=false;
				for (boolean b:used){
					if (!b) {
						reStrings.add("NO");
						flag=true;
						break;
					}
					
				}
				if (!flag){
					reStrings.add("YES");
				}
			}
		}
		for (String s:reStrings){
			System.out.println(s);
		}
	}
	
}
