package LeetCode;

public class Contest43_2 {
	public static boolean isprime(int n){
		for (int i=2;i<=(int)Math.sqrt(n);++i){
			if (n%i==0){
				return false;
			}
		}
		return true;
	}
	 public static int minSteps(int n) {
		 if (n==1) return 0;
         if (n==2) return 2;
		 if (isprime(n)) return n;
		 int res=Integer.MAX_VALUE;
	       for (int i=2;i<n;++i){
	    	   if (n%i==0){
	    		   res=Math.min(res, minSteps(i)+n/i);
	    	   }
	       }
           return res;
	    }
	public static void main(String[] args){
		System.out.println(minSteps(9));
	}
}
