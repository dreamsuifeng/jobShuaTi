package NowcoderGAmeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CodeA5 {
	public static int maxCommonDivisor2(int m, int n) {  
	      
		while (m % n != 0) {   
            int temp = m % n;   
            m = n;   
            n = temp;   
        }   
        return n;
    }
	public static int solve(int aa, int b, int c, int[] a, int n,HashMap<Integer, Integer>[] prefix){
		int res=0;
		HashMap<Integer, Integer> a1;
		if (aa==1){
			a1=new HashMap<>();
		}else{
			a1=prefix[aa-2];
		}
		
		HashMap<Integer, Integer> a2=prefix[b-1];
		LinkedList<Map.Entry<Integer, Integer>> rolls=new LinkedList<>(a2.entrySet());
		while(!rolls.isEmpty()){
			Map.Entry<Integer, Integer> tmp=rolls.pollFirst();
			if (a1.containsKey(tmp.getKey())){
				int t=tmp.getValue()-a1.get(tmp.getKey());
				if (maxCommonDivisor2(t, c)==1){
					res++;
				}
			}
		}
		return res;
	}
	public static void main(String[] args){
//		System.out.println(maxCommonDivisor2(14, 2));
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int[] a=new int[n];
		HashMap<Integer, Integer>[] prefix=new HashMap[n]; 
		Map<Integer, Integer> all=new HashMap<>();
		for(int i=0;i<n;++i){
			
			a[i]=in.nextInt();
			if (all.containsKey(a[i])){
				all.put(a[i], all.get(a[i])+1);
			}else {
				all.put(a[i],1);
			}
			prefix[i]=new HashMap<>(all);
			
		}
		for (int j=0;j<m;++j){
			int aa=in.nextInt();
			int b=in.nextInt();
			int c=in.nextInt();
			System.out.println(solve(aa, b, c, a, n, prefix));
		}
	}
}
