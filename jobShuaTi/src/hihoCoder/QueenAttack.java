package hihoCoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class QueenAttack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		HashMap<Integer,Integer> xHashMap= new HashMap<>();
		HashMap<Integer, Integer> yHashMap=new HashMap<>();
		HashMap<Integer, Integer> leftMap=new HashMap<>();
		HashMap<Integer, Integer> rightMap=new HashMap<>();
		for (int i=0;i<N;++i){
			int x=in.nextInt();
			int y=in.nextInt();
			if (xHashMap.containsKey(x)){
				xHashMap.put(x, xHashMap.get(x)+1);
			}else{
				xHashMap.put(x, 1);
			}
			if (yHashMap.containsKey(y)){
				yHashMap.put(y, yHashMap.get(y)+1);
			}else{
				yHashMap.put(y, 1);
			}
			int sum=x+y;
			int diff=x-y;
			if (leftMap.containsKey(sum)){
				leftMap.put(sum, leftMap.get(sum)+1);
			}else{
				leftMap.put(sum, 1);
			}
			if (rightMap.containsKey(diff)){
				rightMap.put(diff, rightMap.get(diff)+1);
			}else{
				rightMap.put(diff, 1);
			}
		}
		int res=0;
		Iterator<Map.Entry<Integer,Integer>> it=xHashMap.entrySet().iterator();
		while (it.hasNext()){
			int t=it.next().getValue();
			if (t>1) res+=t*(t-1)/2;
		}
		
		Iterator<Map.Entry<Integer,Integer>> it1=yHashMap.entrySet().iterator();
		while (it1.hasNext()){
			int t=it1.next().getValue();
			if (t>1) res+=t*(t-1)/2;
		}
		
		Iterator<Map.Entry<Integer,Integer>> it2=leftMap.entrySet().iterator();
		while (it2.hasNext()){
			int t=it2.next().getValue();
			if (t>1) res+=t*(t-1)/2;
		}
		
		Iterator<Map.Entry<Integer,Integer>> it3=rightMap.entrySet().iterator();
		while (it3.hasNext()){
			int t=it3.next().getValue();
			if (t>1) res+=t*(t-1)/2;
		}
		System.out.println(res);
	}

}
