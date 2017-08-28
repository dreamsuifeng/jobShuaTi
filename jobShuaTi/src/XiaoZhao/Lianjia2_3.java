package XiaoZhao;

import java.util.Arrays;
import java.util.Scanner;

public class Lianjia2_3 {
	private static int solve(int[] mathd, int[] csd,int m,int n,double meanmath,double meancs,int summath,int sumcs){
		Arrays.sort(csd);
		boolean[] used=new boolean[m];
		int s=0;
		int ans=0;
		while (true){
			boolean flag=false;
			for (int i=s;i<m;++i){
				if (!used[i] && csd[i]<meancs && csd[i]>meanmath){
					used[i]=true;
					n++;
					summath+=csd[i];
					meanmath=summath/(double)n;
					m--;
					sumcs-=csd[i];
					meancs=sumcs/(double)m;
					ans++;
					s=i;
					flag=true;
				}
			}
			if (!flag){
				break;
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int[] mathd=new int[N];
		int sumMath=0;
		for (int i=0;i<N;++i){
			
			mathd[i]=in.nextInt();
			sumMath+=mathd[i];
		}
		int sumCs=0;
		
		int M=in.nextInt();
		int[] csd=new int[M];
		for (int i=0;i<M;++i){
			csd[i]=in.nextInt();
			sumCs+=csd[i];
		}
		double meanMath=sumMath/(double)N;
		double meanCs=sumCs/(double)M;
		System.out.println(solve(mathd, csd, M, N, meanMath, meanCs, sumMath, sumCs));
	}

}
