package LeetCode;

import java.math.BigInteger;

public class SmallestGoodBase483 {
	public String smallestGoodBase(String n) {
		long nn = Long.parseLong(n);
		  long res = 0;
		  for(int k = 60; k >= 2; k--){
		    long s = 2, e = nn;
		    while(s < e){
		        long m = s + (e - s) / 2;   
		        
		        long left = (long) Math.pow(m, k);
		        long right = nn*(m-1);
		        long cmr = left-right;
		        if(cmr == 0){
		            res =  m;
		            break;
		        } else if(cmr < 0){
		            s = m + 1;
		        } else {
		            e = m;
		        }
		    }
		    
		    if(res != 0) break;
		  }
		  
		  return "" + res;
    }
}
