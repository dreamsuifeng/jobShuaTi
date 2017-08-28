package LeetCode;

public class RangeAddition598 {
	 public int maxCount(int m, int n, int[][] ops) {
		 	int r=m,c=n;
		 	for (int i=0;i<ops.length;++i){
		 		r=Math.min(r, ops[i][0]);
		 		c=Math.min(c,ops[i][1]);
		 	}
		 	return r*c;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
