package DiDiContest;

import java.util.*;
public class Restaurant {
	static class Guests{
		long people;
		long money;
		public Guests(long p,long m){
			this.people=p;
			this.money=m;
		}
	}
	static TreeMap<Long, Integer> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		map=new TreeMap<>();
		for (int i=0;i<n;++i){
			long a=in.nextLong();
			if (map.containsKey(a)){
				map.put(a, map.get(a)+1);
			}else{
				map.put(a, 1);
			}
			
		}
		
		PriorityQueue<Guests> queue=new PriorityQueue<>(16,new Comparator<Guests>() {

			@Override
			public int compare(Guests o1, Guests o2) {
				// TODO Auto-generated method stub
				if (o1.money!=o2.money) return (int) (o2.money-o1.money);
				else return (int) (o1.people-o2.people);
			}
		});
		
		for (int i=0;i<m;++i){
			long p=in.nextLong();
			long mon=in.nextLong();
			queue.add(new Guests(p, mon));
		}
		long res=0;
		while (!queue.isEmpty()){
			Guests t=queue.poll();
			long key=-1;
			try{
				key=map.ceilingKey(t.people);
			}catch (NullPointerException e){
				continue;
			}
			res+=t.money;
			if (map.get(key)==1){
				map.remove(key);
			}else{
				map.put(key, map.get(key)-1);
			}
		}
		System.out.println(res);
	}

}
