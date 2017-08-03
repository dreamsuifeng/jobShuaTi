package LeetCode;

public class DiagonalTraverse498 {
	public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return new int[0];
        int m=matrix.length;
        int n=matrix[0].length;
        int[] res=new int[m*n];
        int index=0;
        boolean up=true;
        for (int i=0;i<(m+n-2);++i){
        	if (up){
        		int r=Math.min(i, m-1),c=i-r;
        		while (r>=0 && c<n){
        			res[index++]=matrix[r][c];
        			r--;
        			c++;
        		}
        		up=!up;
        	}else {
        		int c=Math.min(i,n-1),r=i-c;
        		while (r<m && c>=0){
        			res[index++]=matrix[r][c];
        			r++;
        			c--;
        		}
        		up=!up;
			}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
