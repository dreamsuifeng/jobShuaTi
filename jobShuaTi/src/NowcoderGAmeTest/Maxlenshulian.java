package NowcoderGAmeTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Maxlenshulian {
	static int[] dp;
	public static int gcd(int m, int n) {  
		if(m==1||n==1) return 1; 
		while (m % n != 0) {   
			int temp = m % n;   
            m = n;   
            n = temp;   
        }   
        return n;
    }
//	public static int solve(int[] value, boolean[] isvisited, int index, HashMap<Integer, LinkedList<Integer>> graph, int tmplen, long preMax){
//		LinkedList<Integer> tmp=graph.get(index);
//		if(tmp.size()==0) return 1;
//		int maxlen=1;
//		for (int i=0;i<tmp.size();++i){
//			int t=tmp.get(i);
//			if (!isvisited[t-1]){
//				isvisited[t-1]=true;
//				long yueshu=gcd(preMax, (long)value[t-1]);
//				if (yueshu>1)
//					maxlen=Math.max(maxlen,1+solve(value, isvisited, t, graph, tmplen+1, yueshu));
//				isvisited[t-1]=false;
//			}
//			
//		}
//		
//		
//		return maxlen;
//	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        int source[] = new int[n-1];
        int target[] = new int[n-1];
         
        for(int i=0; i<n-1; ++i)
        {
            source[i] = sc.nextInt();
            target[i] = sc.nextInt();
        }
 
        int val[] = new int[n];
        for(int j=0; j<n; ++j)
            val[j] = sc.nextInt();
        int level[] = new int[n];
 
        int maxl = 1;
        for(int i=0; i<n-1; ++i){
            val[target[i]-1] = gcd(val[source[i]-1], val[target[i]-1]);
 
            level[target[i]-1] = level[source[i]-1]+1;
            if(val[target[i]-1] > 1){
                if(level[target[i]-1]+1 > maxl)
                    maxl = level[target[i]-1]+1;
            }
        }
 
        System.out.println(maxl);
 
    }

}
