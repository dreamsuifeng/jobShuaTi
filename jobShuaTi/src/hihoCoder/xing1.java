package hihoCoder;

import java.util.HashMap;
import java.util.Scanner;

public class xing1 {
	static long help(long x, long y ,long z,int n,long[] d){
		long res=0;
		HashMap<Long, Long> map=new HashMap<>();
		long as=0;
		for (int i=0;i<n-1;++i){
			as+=d[i];
			if (as==x+y){
				if (map.containsKey(x)){
					res+=map.get(x);
				}
			}
			if (map.containsKey(as)){
				map.put(as, map.get(as)+1);
			}else{
				map.put(as, 1l);
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(-5%3);
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		long[] d=new long[N];
		long sum=0;
		for (int i=0;i<N;i++){
			d[i]=in.nextLong();
			sum+=d[i];
		}
		long m=Math.abs(sum)%3;
		long mean=sum/3;
		long res=0l;
		if(mean>0){
			if (m==0){
				res+=help(mean, mean, mean, N,d);
			}else if (m==1){
				res+=help(mean+1, mean, mean, N, d)+help(mean, mean+1, mean, N, d)+help(mean, mean, mean+1, N, d);
			}else{
				res+=help(mean+1, mean+1, mean, N, d)+help(mean, mean+1, mean+1, N, d)+help(mean+1, mean, mean+1, N, d);
			}
		}else{
			if (m==0){
				res+=help(mean, mean, mean, N,d);
			}else if (m==1){
				res+=help(mean-1, mean, mean, N, d)+help(mean, mean-1, mean, N, d)+help(mean, mean, mean-1, N, d);
			}else{
				res+=help(mean-1, mean-1, mean, N, d)+help(mean, mean-1, mean-1, N, d)+help(mean-1, mean, mean-1, N, d);
			}
		}
		System.out.println(res);
		
		
	}

}
