package NowcoderGAmeTest;

import java.util.Arrays;
import java.util.Scanner;

public class MagicHuan {
	static class mat{
		int[][] d;
		int m;
		int n;
		public mat(int m, int n){
			d=new int[m][n];
			this.m=m;
			this.n=n;
			
		}
	}
	public static mat multi(mat a, mat b){
		int m=a.m;
		int n=b.n;
		mat result=new mat(m, n);
		for (int i=0;i<m;++i){
			for (int j=0;j<n;++j){
				for (int k=0;k<a.n;++k){
					result.d[i][j]=(result.d[i][j]+a.d[i][k]*b.d[k][j])%100;
				}
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[][] d=new int[1][n];
		long sum=0;
		for (int i=0;i<n;++i){
			
			d[0][i]=in.nextInt();
		}
		
		mat init=new mat(n, n);
		mat nums=new mat(1, n);
		nums.d=d;
		
		for (int i=0;i<n-1;++i){
			init.d[i][i]=1;
			init.d[i+1][i]=1;
		}
		init.d[0][n-1]=1;
		init.d[n-1][n-1]=1;
		while (k>0){
			if ((k&1)==1) nums=multi(nums, init);
			init=multi(init, init);
			k>>=1;
		}
		for (int i=0;i<n;++i){
			System.out.print(nums.d[0][i]);
			if (i<n-1){
				System.out.print(" ");
			}
		}
		
	}

}
