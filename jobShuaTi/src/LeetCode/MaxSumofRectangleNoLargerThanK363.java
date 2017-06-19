package LeetCode;

import java.util.TreeSet;

public class MaxSumofRectangleNoLargerThanK363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
	    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
	        return 0;
	    int rows = matrix.length, cols = matrix[0].length;
	    int[][] areas = new int[rows][cols];
	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            int area = matrix[r][c];
	            if (r-1 >= 0)
	                area += areas[r-1][c];
	            if (c-1 >= 0)
	                area += areas[r][c-1];
	            if (r-1 >= 0 && c-1 >= 0)
	                area -= areas[r-1][c-1];
	            areas[r][c] = area;
	        }
	    }
	    int max = Integer.MIN_VALUE;
	    for (int r1 = 0; r1 < rows; r1++) {
	        for (int r2 = r1; r2 < rows; r2++) {
	            TreeSet<Integer> tree = new TreeSet<>();
	            tree.add(0);    // padding
	            for (int c = 0; c < cols; c++) {
	                int area = areas[r2][c];
	                if (r1-1 >= 0)
	                    area -= areas[r1-1][c];
	                Integer ceiling = tree.ceiling(area - k);
	                if (ceiling != null)
	                    max = Math.max(max, area - ceiling);
	                tree.add(area);
	            }
	        }
	    }
	    return max;
	}
	
	public int maxSumSubmatrix1(int[][] matrix, int target) {
	    int row = matrix.length;
	    if(row==0)return 0;
	    int col = matrix[0].length;
	    int m = Math.min(row,col);
	    int n = Math.max(row,col);
	    //indicating sum up in every row or every column
	    boolean colIsBig = col>row;
	    int res = Integer.MIN_VALUE;
	    for(int i = 0;i<m;i++){
	        int[] array = new int[n];
	        // sum from row j to row i
	        for(int j = i;j>=0;j--){
	            int val = 0;
	            TreeSet<Integer> set = new TreeSet<Integer>();
	            set.add(0);
	            //traverse every column/row and sum up
	            for(int k = 0;k<n;k++){
	                array[k]=array[k]+(colIsBig?matrix[j][k]:matrix[k][j]);
	                val = val + array[k];
	                //use  TreeMap to binary search previous sum to get possible result 
	                Integer subres = set.ceiling(val-target);
	                if(null!=subres){
	                    res=Math.max(res,val-subres);
	                }
	                set.add(val);
	            }
	        }
	    }
	    return res;
	}
	public static void main(String[] args){
		String str="ABCDE";
		System.out.println(str.replaceAll("/*", "X"));
	}
}
