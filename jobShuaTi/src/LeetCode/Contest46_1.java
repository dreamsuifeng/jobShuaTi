package LeetCode;

public class Contest46_1 {
	public int[][] imageSmoother(int[][] M) {
		if (M==null) return M;
		int[][] direc={{0,-1},{-1,0},{1,0},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
        int m=M.length;
        int n=M[0].length;
        int[][] res=new int[m][n];
        for (int i=0;i<m;++i){
        	for (int j=0;j<n;++j){
        		int sum=0;
        		int c=0;
        		for (int k=0;k<direc.length;++k){
        			int x=i+direc[k][0];
        			int y=j+direc[k][1];
        			if (x>=0 && y>=0 && x<m && y<n){
        				c++;
        				sum+=M[x][y];
        			}
        		}
        		res[i][j]=sum/c;
        	}
        }
        return res;
    }
}
