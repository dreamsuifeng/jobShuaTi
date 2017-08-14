package LeetCode;

import java.util.LinkedList;
import java.util.Queue;


public class _01Matrix542 {

	 public int[][] updateMatrix(int[][] matrix) {
		 if (matrix==null) return new int[0][0];
		 int m=matrix.length;
		 if (m==0) return new int[0][0];
		 int n=matrix[0].length;
		 if (n==0) return new int[0][0];
		 int[][] res=new int[m][n];
		 for (int i=0;i<m;++i){
			 for (int j=0;j<n;++j){
				 res[i][j]=Integer.MAX_VALUE;
				 if (matrix[i][j]==0) res[i][j]=0;
				 else {
					 if (i-1>=0){
						 res[i][j]=Math.min(res[i-1][j]+1, res[i][j]);
					 }
					 if (j-1>=0){
						 res[i][j]=Math.min(res[i][j-1]+1,res[i][j]);
					 }
				 }
			 }
		 }
		 for (int i=0;i<m;++i){
			 for (int j=0;j<n;++j){
				 if (matrix[i][j]==0) res[i][j]=0;
				 else {
					 if (i+1<m){
						 res[i][j]=Math.min(res[i+1][j]+1, res[i][j]);
					 }
					 if (j+1<n){
						 res[i][j]=Math.min(res[i][j+1]+1,res[i][j]);
					 }
				 }
			 }
		 }
		 return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_01Matrix542 t=new _01Matrix542();
		int[][] data={{0,0,0},{0,1,0},{1,1,1}};
		int[][] ana=t.updateMatrix(data);
	}

}
