package hihoCoder;

import java.util.Scanner;

public class leetcode1538 {
	static boolean help(int[][] test,int[][] litang, int i,int j,int H,int W){
		if (i+H>=litang.length || j+W>=litang[0].length) return false;
		for (int i1=0;i1<H;++i1){
			for (int j1=0;j1<W;++j1){
				if (test[i1][j1]!=litang[i+i1][j+j1]){
					return false;
				}
			}
		}
		return true;
	}
	static String solve(int[][] test, int[][] litang, int N, int M, int H, int W){
		int rCount=H/N+1;
		int cCount=W/M+1;
		int[][] newlitang=new int[N*rCount][cCount*M];
		for (int i=0;i<newlitang.length;++i){
			for (int j=0;j<newlitang[0].length;++j){
				newlitang[i][j]=litang[i%N][j%M];
			}
		}
//		print(newlitang);
		for (int i=0;i<newlitang.length;++i){
			for (int j=0;j<newlitang[0].length;++j){
				if (newlitang[i][j]==test[0][0]){
					if (help(test, newlitang, i, j, H, W)) return "YES";
				}
			}
		}
		return "NO";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		int K=in.nextInt();
		int[][] litang=new int[N][M];
		in.nextLine();
		for (int i=0;i<N;++i){
			char[] t=in.nextLine().toCharArray();
			for (int j=0;j<M;++j){
				litang[i][j]=t[j]-'A';
			}
			
		}
		
		for (int t=0;t<K;++t){
			int H=in.nextInt();
			int W=in.nextInt();
			in.nextLine();
			int[][] test=new int[H][W];
			for (int i1=0;i1<H;++i1){
				char[] t1=in.nextLine().toCharArray();
				for (int j1=0;j1<W;++j1){
					test[i1][j1]=t1[j1]-'A';
				}
			}
			System.out.println(solve(test, litang, N, M, H, W));
		}
	}

}
