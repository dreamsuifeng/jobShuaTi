package LeetCode;

public class TeemoAttacking495 {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
       int start=0;
       int end=0;
       int res=0;
       for (int i=0;i<timeSeries.length;++i){
    	  if (timeSeries[i]>end){
    		  res+=end-start+1;
    		  start=timeSeries[i];
    		  end=start+duration-1;
    	  }else{
    		  end=timeSeries[i]+duration-1;
    	  }
       }
       res+=end-start+1;
       return res;
    }
}
