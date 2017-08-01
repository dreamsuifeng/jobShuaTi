package hihoCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Leetcode1541 {
	
	static void print(int[][] path){
		for (int[] i:path){
			for (int j:i){
				System.out.print(j+",");
			}
			System.out.println();
		}
	}
	
	
	static boolean dfs(Map<Integer, LinkedList<Integer>> maps, int ori, int tar, int cur, LinkedList<Integer> path,boolean[] used){
		if (cur==tar){
			return true;
		}
		LinkedList<Integer> nearnodes=maps.get(cur);
		for(int i:nearnodes){
			if (!used[i]){
				used[i]=true;
				if (dfs(maps, ori, tar, i, path,used)){
					path.add(i);
					return true;
				}
				used[i]=false;
			}
		}
		return false;
		
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for (int i=0;i<T;++i){
			int n=in.nextInt();
			int m=in.nextInt();
			Map<Integer, LinkedList<Integer>> maps=new HashMap<>();
			for (int j=0;j<n-1;++j){
				int r=in.nextInt();
				int c=in.nextInt();
				if (maps.containsKey(r-1)){
					maps.get(r-1).add(c-1);
				}else {
					LinkedList<Integer> tmp=new LinkedList<>();
					tmp.add(c-1);
					maps.put(r-1,tmp);
				}
				if (maps.containsKey(c-1)){
					maps.get(c-1).add(r-1);
				}else {
					LinkedList<Integer> tmp=new LinkedList<>();
					tmp.add(r-1);
					maps.put(c-1,tmp);
				}
				
			}
			for (int m1=0;m1<m;++m1){
				int x1=in.nextInt();
				int y1=in.nextInt();
				int x2=in.nextInt();
				int y2=in.nextInt();
			
				LinkedList<Integer> p1=new LinkedList<>();
				p1.add(x1-1);
				LinkedList<Integer> p2=new LinkedList<>();
				p2.add(x2-1);
				boolean[] b1=new boolean[n];
				b1[x1-1]=true;
				boolean[] b2=new boolean[n];
				b2[x2-1]=true;
				dfs(maps, x1-1, y1-1, x1-1, p1, b1);
				dfs(maps, x2-1, y2-1, x2-1, p2, b2);
				System.out.println(p1.toString());
				System.out.println(p2.toString());
				Set<Integer> p11=new HashSet<>(p1);
				boolean flag=false;
				for (int num:p2){
					if (p11.contains(num)){
						flag=true;
						System.out.println("YES");
						break;
						
					}
				}
				if (!flag){
					System.out.println("NO");
				}
				
			
			}
		}
	}
}
