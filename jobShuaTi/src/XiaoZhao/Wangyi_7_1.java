package XiaoZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class Wangyi_7_1 {
	private static int ans=0;
	private static HashSet<List<String>> set=new HashSet<>();
	public static void dfs(int[] h, List<String> cur, int i,boolean[] used){
		if (i>=h.length){
			if (!set.contains(cur)){
//				System.out.println(cur.toString());
				set.add(cur);
				int sum=0;
				for (int j=1;j<h.length;++j){
					sum+=Math.abs(Integer.parseInt(cur.get(j))-Integer.parseInt(cur.get(j-1)));
				}
//				System.out.println(sum);
				ans=Math.max(ans, sum);
				
			}
			return;
		}
		
		for (int k=0;k<h.length;++k){
			if (!used[k]){
				cur.add(""+h[k]);
				used[k]=true;
				dfs(h, cur, i+1, used);
				used[k]=false;
				cur.remove(cur.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] h=new int[n];
		for (int i=0;i<n;++i){
			h[i]=in.nextInt();
		}
		Arrays.sort(h);
		int ans=0;
		LinkedList<Integer> q=new LinkedList<>();
		q.add(h[0]);
		int i=1,j=n-1;
		while (i<=j){
			int head=q.peekFirst();
			int tail=q.peekLast();
			int crazy1=Math.abs(head-h[i]);
			int crazy2=Math.abs(head-h[j]);
			int crazy3=Math.abs(tail-h[i]);
			int crazy4=Math.abs(tail-h[j]);
			int maxvalue=Math.max(Math.max(crazy1, crazy2),Math.max(crazy3, crazy4));
			if (maxvalue==crazy1){
				q.addFirst(h[i]);
				i++;
			}else if (maxvalue==crazy2){
				q.addFirst(h[j]);
				j--;
			}else if (maxvalue==crazy3){
				q.add(h[i]);
				i++;
			}else{
				q.add(h[j]);
				j--;
			}
		}
		for (int k=1;k<n;++k){
			ans+=Math.abs(q.get(k)-q.get(k-1));
		}
		System.out.println(ans);
	}

}
