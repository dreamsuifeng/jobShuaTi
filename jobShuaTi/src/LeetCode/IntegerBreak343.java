package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak343 {
	private static Map<Integer, Integer> map=new HashMap<>();
	 public int integerBreak(int n) {
		 if (map.containsKey(n)) return map.get(n);
		 if (n==2) return 2;
		 if (n==1) return 1;
		 int tmp=Integer.MIN_VALUE;
	        for (int i=1;i<=n/2;i++){
	        	int t=integerBreak(i)*integerBreak(n-i);
	        	int ts=i*integerBreak(n-i);
	        	int tb=integerBreak(i)*(n-i);
	        	int tt=i*(n-i);
	        	int maxtemp=Math.max(Math.max(t, ts),tb);
	        	tmp=Math.max(tmp,Math.max(maxtemp, tt));
	        }
	        System.out.println(n+"-->"+tmp);
	        map.put(n, tmp);
	        return tmp;
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new IntegerBreak343().integerBreak(54));
	}

}
