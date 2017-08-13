package NowcoderGAmeTest;

import java.util.Scanner;

public class huurytoCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] taxis=new int[n][2];
		for (int i=0;i<n;++i){
			taxis[i][0]=in.nextInt();
			
		}
		for (int i=0;i<n;++i){
			taxis[i][1]=in.nextInt();
		}
		int gx=in.nextInt();
		int gy=in.nextInt();
		int walkTime=in.nextInt();
		int taxiTime=in.nextInt();
		int res=(Math.abs(gx)+Math.abs(gy))*walkTime;
		for (int i=0;i<n;++i){
			int wt=(Math.abs(taxis[i][0])+Math.abs(taxis[i][1]))*walkTime;
			int x=taxis[i][0];
			int y=taxis[i][1];
			int tt=(Math.abs(gx-x)+Math.abs(gy-y))*taxiTime;
			if (tt+wt<res){
				res=tt+wt;
			}
		}
		System.out.println(res);
	}

}
