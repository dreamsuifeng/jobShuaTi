package LeetCode;

public class LongestIncreasingPathinaMatrix {
	private int Longlen=Integer.MIN_VALUE;
	private int[][] mem;
	public int findlongestPath(int[][] matrix, int i, int j) {
//		tmplen++;
//		Longlen=Math.max(Longlen, tmplen);
		if (mem[i][j]!=0) return mem[i][j];
		int a=1,b=1,c=1,d=1;
        if (i-1>=0 && matrix[i-1][j]>matrix[i][j]){
        	a=1+findlongestPath(matrix, i-1, j);
        }
        if (j-1>=0 && matrix[i][j-1]>matrix[i][j]){
        	b=1+findlongestPath(matrix, i, j-1);
        }
        if(i+1<matrix.length && matrix[i+1][j]>matrix[i][j]){
        	c=1+findlongestPath(matrix, i+1, j);
        }
        if (j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]){
        	d=1+findlongestPath(matrix, i, j+1);
        }
        int maxk=a;
        maxk=Math.max(maxk, b);
        maxk=Math.max(maxk, c);
        maxk=Math.max(maxk, d);
        mem[i][j]=maxk;
        return maxk;
        
    }
	public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        if (n==0) return 0;
        mem=new int[m][n];
        for (int i=0;i<m;++i){
        	for (int j=0;j<n;++j){
        		int t=findlongestPath(matrix, i, j);
        		Longlen=Math.max(t, Longlen);
        	}
        }
        return Longlen;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.valueOf(11));
	}

}
