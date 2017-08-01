package hihoCoder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Hiho20_4 {
	public static void solve(int cur, int[] parent,boolean[] used,HashMap<Integer, List<Integer>> edges){
		if (used[cur]==true) return;
		used[cur]=true;
		List<Integer> childs=edges.get(cur);
		for (Integer i:childs){
			if (!used[i]){
			parent[i]=cur;
			solve(i, parent, used, edges);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int K=in.nextInt();
		HashMap<Integer, List<Integer>> edges=new HashMap<>();
		for (int i=0;i<N-1;++i){
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
		boolean[] used=new boolean[N+1];
		int[] parent=new int[N+1];
		solve(K, parent, used, edges);
		for (int i=1;i<parent.length;++i){
			System.out.print(parent[i]);
			if (i<parent.length){
				System.out.print(" ");
			}
		}
	}

}
