package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumFactorization625 {
	public List<Integer> primeFact(int n){
		List<Integer> res=new LinkedList<>();
		 while (n%2==0)
	        {
	            res.add(2);
	            n /= 2;
	        }
		 for (int i = 3; i <= Math.sqrt(n); i+= 2){
	        
	            // While i divides n, print i and divide n
	            while (n%i == 0)
	            {
	                res.add(i);
	                n /= i;
	            }
	        
		 }
		 if (n>2){
			 res.add(n);
		 }
		 return res;
	}
	public int smallestFactorization(int a) {
		if (a==1) return 1;
		PriorityQueue<Integer> queue=new PriorityQueue<>();
       for(int i=9;i>1;--i){
    	   while(a%i==0 && a!=1){
    		   
    		   queue.add(i);
    		   a/=i;
//    		   long t=i*(long)Math.pow(10,((int)Math.log10(a)+1))+a;
//    		   if (t>Integer.MAX_VALUE) return 0;
    	   }
       }
       if (a>9) return 0;
       System.out.println(queue.toString());
       long res=0;
       while(!queue.isEmpty()){
    	   res=res*10+queue.poll();
    	   if (res>2147483647) return 0;
       }
       
       return (int)res;
        	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinimumFactorization625().smallestFactorization(123451254));
	}

}
