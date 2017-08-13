package XiaoZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Wangyi_7 {
	static class node{
		int l;
		int r;
		int val;
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
		ArrayList<node> list=new ArrayList<>();
		int i=0,j=n-1;
		int ans=0;
		while (i<=j){
			node t=new node();
			t.l=h[i];
			t.r=h[j];
			t.val=Math.abs(t.l-t.r);
			ans+=t.val;
			list.add(t);
			i++;
			j--;
		}
		
		while (list.size()>1){
			
			ArrayList<node> tmp=new ArrayList<>();
			while (list.size()>0){
				int id1=0;
				int id2=0;
				int maxval=0;
				for (int i1=0;i1<list.size();++i1){
					for (int jj=i1+1;jj<list.size();++jj){
						int max=Math.max(Math.max(list.get(i1).l, list.get(i1).r)-
								Math.min(list.get(jj).l,list.get(jj).l), Math.max(list.get(jj).l, list.get(jj).r)-
								Math.min(list.get(i1).l,list.get(i1).l));
						if (max>maxval){
							maxval=max;
							id1=i1;
							id2=jj;
						}
					}
				}
				
				int val1=Math.max(list.get(id1).l, list.get(id1).r)-
						Math.min(list.get(id2).l,list.get(id2).l);
				int val2=Math.max(list.get(id2).l, list.get(id2).r)-
						Math.min(list.get(id1).l,list.get(id1).l);
				node tmp1=new node();
				if (val1>val2){
					tmp1.l=Math.min(list.get(id1).l,list.get(id1).r);
					tmp1.r=Math.max(list.get(id2).l, list.get(id2).r);
				}else{
					tmp1.l=Math.min(list.get(id2).l,list.get(id2).r);
					tmp1.r=Math.max(list.get(id1).l, list.get(id1).r);
				}
				list.remove(id1);
				if(id2<id1){
					list.remove(id2);
				}else if (id2>id1){
					list.remove(id1);
				}
				ans+=maxval;
				tmp.add(tmp1);
			}
			list.addAll(tmp);
		}
		System.out.println(ans);
	}
}
