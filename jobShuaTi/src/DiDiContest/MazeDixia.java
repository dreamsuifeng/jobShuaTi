package DiDiContest;


import java.util.*;
public class MazeDixia {
	static int[][] direc={{1,0},{0,1},{0,-1},{-1,0}};
	static List<int[]> res=new LinkedList<>();
	static int minTili=Integer.MAX_VALUE;
	static List<int[]> ans= new LinkedList<>();
	public static void dfs(int[][] maze,int p,int curP,int i,int j,int m,int n,boolean[][] used){
		if (curP>p) return ;
		if (curP<=p && i==0 && j==m-1){
//			System.out.println("yes");
			if (minTili>curP){
				minTili=curP;
				ans.clear();
				ans.addAll(res);
			}
		}
		for (int k=0;k<4;++k){
			int x=i+direc[k][0];
			int y=j+direc[k][1];
			if (x>=0 && x<n && y>=0 && y<m && maze[x][y]==1 && !used[x][y]){
				used[x][y]=true;
				int[] t=new int[2];
				t[0]=x;
				t[1]=y;
				res.add(t);
				if (k==2){
					dfs(maze, p, curP+1, x, y, m, n, used);
				}else{
					dfs(maze, p, curP+k, x, y, m, n, used);
				}
				
				used[x][y]=false;
				res.remove(res.size()-1);
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int p=in.nextInt();
		int[][] maze=new int[n][m];
		for (int i=0;i<n;++i){
			for (int j=0;j<m;++j){
				maze[i][j]=in.nextInt();
			}
		}
		res.add(new int[]{0,0});
		boolean[][] used=new boolean[n][m];
		used[0][0]=true;
		dfs(maze, p, 0, 0, 0, m, n, used);
		if (ans.size()==0){
			System.out.println("Can not escape!");
			return;
		}
		for (int i=0;i<ans.size();++i){
			int[] t=ans.get(i);
			System.out.print("["+t[0]+","+t[1]+"]");
			if (i<ans.size()-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}

}
