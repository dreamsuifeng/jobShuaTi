package LeetCode;

public class OutofBoundaryPaths576 {
	private int sum=0;
    int [][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        long [][][]dp=new long[m+2][n+2][N+1];
        
        dp[i+1][j+1][0]=1;
        for(int k=0;k<N;k++){
            for(int p=0;p<m+2;p++)
            for(int q=0;q<n+2;q++)
            {
                for(int []d:dirs){
                    int x=p+d[0],y=q+d[1];
                    if(x>=1&&y>=1&&x<=m&&y<=n)
                        dp[p][q][k+1]+=(dp[x][y][k]%(1000000007)+(1000000007))%(1000000007);
                }
                if(p==0||q==0||p==m+1||q==n+1)
                {
                    sum+=((long)dp[p][q][k+1]%(1000000007));
                    sum=sum%(1000000007);
                }
            }
        }
        return (int)sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
