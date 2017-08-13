package hihoCoder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import sun.security.action.PutAllAction;

public class hiho28_4 {
	public static long fastPow(long n,long mod,int k){
		long r=1;
		while (k>0){
			if ((k&1)==1) r=(r*n)%mod;
			n=(n*n)%mod;
			k>>=1;
		}
		return r;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		long mod=1000000007l;
		for (int t=0;t<T;++t){
			int N=in.nextInt();
			int M=in.nextInt();
			int[] d=new int[N];
			HashMap<Integer, Integer>[] records=new HashMap[N];
			HashMap<Integer, Integer> map=new HashMap<>();
			for (int j=0;j<N;++j){
				d[j]=in.nextInt();
				if (map.containsKey(d[j])){
					map.put(d[j], map.get(d[j])+1);
				}else{
					map.put(d[j], 1);
				}
			}
			for (int j=0;j<M;++j){
				int li=in.nextInt();
				int ri=in.nextInt();
				int k=in.nextInt();
				long ans=0;
				for (int i1=li-1;i1<=ri-1;++i1){
					ans=(ans+fastPow(d[i1], mod, k))%mod;
				}
				System.out.println(ans);
			}
			
		}
		
		
	}

}
