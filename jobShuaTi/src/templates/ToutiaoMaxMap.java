package templates;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class ToutiaoMaxMap {
	static class node{
		char c;
		int count;
		public node(char c,int co){
			this.c=c;
			this.count=co;
		}
	}
	
	public static boolean stopLoop(int[] mapCtoInt){
		for (int i=0;i<mapCtoInt.length;++i){
			if (mapCtoInt[i]==-1){
				return false;
			}
		}
		return true;
	}
	public static void findSameSesond(List<Integer> candidates,int len,HashMap<Integer, int[]> maps){
		if (len<=0){
			return;
		}
		if (candidates.size()==1){
			return;
		}
		if (!maps.containsKey(len)){
			findSameSesond(candidates, len--, maps);
		}else{
			int[] tmp=maps.get(len);
			int max=-1;
			for (int i=0;i<candidates.size();++i){
				max=Math.max(max, tmp[candidates.get(i)]);
			}
			List<Integer> list=new ArrayList<>();
			for (int i=0;i<candidates.size();++i){
				if (tmp[candidates.get(i)]==max){
					list.add(candidates.get(i));
				}
			}
			candidates.clear();
			candidates.addAll(list);
			findSameSesond(candidates, len--, maps);
		}
		
	}
	public static char findMax(HashMap<Integer, int[]> maps, boolean[] arrange){
		int len=12;
		while (len>0){
			if (!maps.containsKey(len)){
				continue;
			}
			int[] tmp=maps.get(len);
			int maxCount=0;
			List<Integer> maxIndexs=new ArrayList<>();
			for (int i=0;i<tmp.length;++i){
				if (tmp[i]>maxCount && !arrange[i]){
					maxCount=tmp[i];
					maxIndexs.clear();
					maxIndexs.add(i);
				}else if (tmp[i]==maxCount && !arrange[i]){
					maxIndexs.add(i);
				}
			}
			if (maxIndexs.size()==1){
				return (char) ('A'+maxIndexs.get(0));
			}else{
				findSameSesond(maxIndexs, len--, maps);
				return (char)('A'+maxIndexs.get(0));
			}
		}
		return 'A';
		
	}
	public static List<node> change(int[] puts){
		List<node> res=new ArrayList<>();
		for (int i=0;i<puts.length;++i){
			res.add(new node((char)('A'+i), puts[i]));
		}
		Collections.sort(res,new Comparator<node>() {

			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				return o2.count-o1.count;
			}
		});
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		HashMap<Integer, int[]> map=new HashMap<>();
		in.nextLine();
		char[][] inputs=new char[n][];
		for (int i=0;i<n;++i){
			char[] line=in.nextLine().toCharArray();
			inputs[i]=line;
			for (int j=1;j<=line.length;++j){
				if (map.containsKey(j)){
					int[] tmp=map.get(j);
					tmp[line[line.length-j]-'A']++;
				}else{
					int[] t=new int[10];
					t[line[line.length-j]-'A']++;
				}
			}
		}
		int[] mapCharToInt=new int[10];
		boolean[] arrange=new boolean[10];
		Arrays.fill(mapCharToInt, -1);
		int len=12;
		int num=9;
		while (!stopLoop(mapCharToInt)){
			char c=findMax(map,arrange);
			arrange[c-'A']=true;
			mapCharToInt[c-'A']=num;
			num--;
		}
		int ans=0;
		for (int i=0;i<inputs.length;++i){
			char[] tmp=inputs[i];
			int r=0;
			for (char c:tmp){
				r=r*10+mapCharToInt[c-'A'];
			}
			ans+=r;
		}
		System.out.println(ans);
		
	}

}
