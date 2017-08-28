package XiaoZhao;

import java.util.*;
public class AliTest2 {
	
	static int res=Integer.MAX_VALUE;
	public static void solve(int[] periods, int[][] roads, int M, int N,int lukouid, int endId, int curtime, boolean[] used){
		if (lukouid==endId){
			res=Math.min(res,curtime);
			return;
		}
		int period=periods[lukouid];
		for (int i=0;i<N;++i){
			if (!used[i] && roads[lukouid][i]>0){
				int a=curtime/period;
				if (a%period==0){
					a-=1;
				}
				if (a%2==0){
					used[i]=true;
					solve(periods, roads, M, N,  i, endId, curtime+roads[lukouid][i], used);
					used[i]=false;
				}else{
					used[i]=true;
					solve(periods, roads, M, N,  i, endId, curtime+roads[lukouid][i]+period-curtime%period, used);
					used[i]=false;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int[] periods=new int[(int) N];
		in.nextLine();
		for (int i=0;i<N;++i){
			String[] line=in.nextLine().split(",");
			int id=Integer.parseInt(line[0]);
			int perio=Integer.parseInt(line[1]);
			periods[id]=perio;
		}
		int M=Integer.parseInt(in.nextLine());
		int[][] roads=new int[N][N];
		for (int i=0;i<M;++i){
			String[] line=in.nextLine().split(",");
			int id1=Integer.parseInt(line[0]);
			int id2=Integer.parseInt(line[1]);
			int time=Integer.parseInt(line[2]);
			roads[id1][id2]=time;
			roads[id2][id1]=time;
		}
		String[] line=in.nextLine().split(",");
		int startid=Integer.parseInt(line[0]);
		int endid=Integer.parseInt(line[1]);
		boolean[] used=new boolean[N];
		used[startid]=true;
		solve(periods, roads, M, N, startid, endid, 0, used);
		System.out.println(res);
		
	}

}
