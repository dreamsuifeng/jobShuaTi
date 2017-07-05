package LeetCode;

public class ArithmeticSlices413 {
	 public static int numberOfArithmeticSlices(int[] A) {
			if (A==null || A.length<3) return 0;
	        int n=A.length;
	        int res=0;
	        int dif=A[1]-A[0];
	        int i=0;
	        while (i<n-1){
	        	int j=i;
	        	while(i<n-1 && A[i]+dif==A[i+1]){
	        		i++;
	        	}
	        	if (i-j+1>=3){
	        		int tmp=0;
	        		for (int k=2;k<i-j+1;++k){
	        			tmp+=(i-j+1-k);
	        		}
	        		res+=tmp;
	        	}
	        	if (i==n-1) break;
	            dif=A[i+1]-A[i];
	        }
	        return res;
	        	
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,6,8}));
	}

}
