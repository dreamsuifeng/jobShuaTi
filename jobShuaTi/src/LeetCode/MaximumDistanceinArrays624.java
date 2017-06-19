package LeetCode;

public class MaximumDistanceinArrays624 {
public static int maxDistance(int[][] arrays) {
        int m=arrays.length;
        if (m==0) return 0;
        int min=Integer.MAX_VALUE;
        int premin=min;
        int max=Integer.MIN_VALUE;
        int premax=max;
        int maxindex=-1;
        int minindex=-1;
        for (int i=0;i<m;++i){
        	int n=arrays[i].length;
        	if (arrays[i][0]<min){
        		premin=min;
        		min=arrays[i][0];
        		minindex=i;
        	}
        	if (arrays[i][n-1]>max){
        		premax=max;
        		maxindex=i;
        		max=arrays[i][n-1];
        	}
        }
        
        return maxindex==minindex ? Math.max(premax-min, max-premin):(max-min);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
