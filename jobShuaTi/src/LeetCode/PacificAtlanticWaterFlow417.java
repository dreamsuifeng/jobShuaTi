package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow417 {
	private void output(boolean[][] m){
		for(boolean[] i:m){
			for(boolean j:i){
				System.out.print(j+",");
			}
			System.out.println();
		}
	}
	private void dfs(boolean[][] viewed,int[][] matrix,int i,int j,int m,int n,int pre){
		if ( i<0 || i>=m || j<0 || j>=n || viewed[i][j] || matrix[i][j]<pre){
			return;
		}
		viewed[i][j]=true;
		int cur=matrix[i][j];
		dfs(viewed, matrix, i+1, j, m, n, cur);
		dfs(viewed, matrix, i-1, j, m, n, cur);
		dfs(viewed, matrix, i, j+1, m, n, cur);
		dfs(viewed, matrix, i, j-1, m, n, cur);
	}
	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix==null || matrix.length==0 || matrix[0].length==0) return new LinkedList<int[]>();
        Queue<int[]> quepac=new LinkedList<>();
        Queue<int[]> queatl=new LinkedList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i=0;i<n;++i){
        	int[] t=new int[2];
        	t[0]=0;
        	t[1]=i;
        	quepac.add(t);
        }
        for (int i=1;i<m;++i){
        	int[] t=new int[2];
        	t[0]=i;
        	t[1]=0;
        	quepac.add(t);
        }
        for (int i=0;i<n;++i){
        	int[] t=new int[2];
        	t[0]=m-1;
        	t[1]=i;
        	queatl.add(t);
        }
        for (int i=0;i<m-1;++i){
        	int[] t=new int[2];
        	t[0]=i;
        	t[1]=n-1;
        	queatl.add(t);
        }
        boolean[][] viewedpac=new boolean[m][n];
        boolean[][] viewedatl=new boolean[m][n];
        while (!quepac.isEmpty()){
        	int[] tmp=quepac.poll();
        	dfs(viewedpac, matrix, tmp[0], tmp[1], m, n, -1);
        }
        while (!queatl.isEmpty()){
        	int[] tmp=queatl.poll();
        	dfs(viewedatl, matrix, tmp[0], tmp[1], m, n,-1);
        }
        output(viewedpac);
        System.out.println();
        output(viewedatl);
        List<int[]> res=new LinkedList<>();
        for (int i=0;i<m;++i){
        	for (int j=0;j<n;++j){
        	
        		if (viewedpac[i][j] && viewedatl[i][j]){
        			int[] t=new int[2];
        			t[0]=i;
        			t[1]=j;
        			res.add(t);
        		}
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow417 t=new PacificAtlanticWaterFlow417();
		int[][] data={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		t.pacificAtlantic(data);
	}

}
