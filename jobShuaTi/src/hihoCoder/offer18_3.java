package hihoCoder;

import java.util.Arrays;
import java.util.Scanner;

public class offer18_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int K=in.nextInt();
		int[][] data=new int[N][3];
		for (int i=0;i<N;++i){
			data[i][0]=in.nextInt();
			data[i][1]=in.nextInt();
			data[i][2]=in.nextInt();
		}
		int[][] dp=new int[N][K+1];
		int[] notchange=Arrays.copyOf(data[0], 3);
		for (int i=1;i<N;++i){
			int tmp=0;
			for (int l=0;l<3;++l){
				tmp+=Math.abs(data[i][l]-data[0][l]);
			}
			dp[i][0]=dp[i-1][0]+tmp;
			for (int j=1;j<K+1;++j){
//				int max=Math.max(Math.max(data[i][0], data[i][1]),data[i][2]);
//				int min=Math.min(Math.min(data[i][0], data[i][1]),data[i][2]);
				int min_value=Integer.MAX_VALUE;
				int min_x=-1;
				boolean daflag=false;
				for (int ii=-200;ii<=200;++ii){
					int a=Math.abs(data[i][0]-ii)+Math.abs(data[i][1]-ii-3)+Math.abs(data[i][2]-ii-7);
					int b=Math.abs(data[i][0]-ii)+Math.abs(data[i][1]-ii-4)+Math.abs(data[i][2]-ii-7);
					int min_a_b=Math.min(a, b);
					
					if (min_a_b<min_value){
						min_value=min_a_b;
						min_x=ii;
						daflag= a>b ? true:false;
					}
				}
				int notchangesum=Math.abs(data[i][0]-notchange[0])+Math.abs(data[i][1]-notchange[1])+Math.abs(data[i][2]-notchange[2]);
				if (dp[i-1][j]+notchangesum<dp[i-1][j-1]+min_value){
					dp[i][j] = dp[i-1][j]+notchangesum;
				}else{
					dp[i][j]=dp[i-1][j-1]+min_value;
					notchange[0]=min_x;
					notchange[1]= daflag ? min_x+4:min_x+3;
					notchange[2]=min_x+7;
				}
			}
		}
		System.out.println(dp[N-1][K]);
	}	

}
