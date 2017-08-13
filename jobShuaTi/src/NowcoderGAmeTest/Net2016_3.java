package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2016_3 {
	
	private static int res;
	public static int stat(int[][] d, int i, int j){
		int ans=0;
		for (int s=i-1;s<=i+1;++s){
			for (int e=j-1;e<=j+1;++e){
				if (d[s][e]>0)
					ans+=1;
			}
		}
		return ans;
	}
	public static void modify(int[][] d, int i, int j){
		for (int s=i-1;s<=i+1;++s){
			for (int e=j-1;e<=j+1;++e){
				d[s][e]-=1;
			}
		}
	}
	public static void reset(int[][] d, int i, int j){
		for (int s=i-1;s<=i+1;++s){
			for (int e=j-1;e<=j+1;++e){
				d[s][e]+=1;
			}
		}
	}
	public static void  solve(int[][] d, int step, int M, int N, int cur){
		if(step>2){
			res=Math.max(res, cur);
			return;
		}
		for (int i=1;i<=M;++i){
			for (int j=1;j<N;++j){
				int t=stat(d, i, j);
				modify(d, i, j);
				solve(d, step+1, M, N, cur+t);
				reset(d, i, j);				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in=new Scanner(System.in);
			while (in.hasNext()){
				int M=in.nextInt();
				int N=in.nextInt();
				int K=in.nextInt();
				int[][] d=new int[M+2][N+2];
				for (int i=0;i<K;++i){
					int x=in.nextInt();
					int y=in.nextInt();
					d[x][y]++;
				}
				res=0;
				solve(d, 1, M, N, 0);
				System.out.println(res);
			}
		}

}
