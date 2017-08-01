package hihoCoder;

import java.util.Scanner;

public class Hiho20_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();
		int T=in.nextInt();
		int K1=in.nextInt();
		int K2=in.nextInt();
		int[][] data=new int[N][2];
		for (int i=0;i<N;++i){
			data[i][0]=in.nextInt();
			data[i][1]=in.nextInt();
			
		}
		int init=M;
		int res=0;
		int works=0;
		int start=0;
		int notworks=0;
		boolean flag=true;
		for (int[] i:data ){
			if ((i[1]-i[0])*K1>M){
				flag=false;
				System.out.println(-1);
				break;
			}
			notworks=i[0]-start;
			res+=(notworks*K2/M+1);
			start=i[1];
			works+=i[1]-i[0];
			
		}
		res=1+(works*K1+(T-works+1)*K2)/M;
		if (flag) System.out.println(res);
		
	}

}
