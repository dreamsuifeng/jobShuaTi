package hihoCoder;

import java.util.Scanner;



public class hiho169 {
	public static long solve(long x,long y, int n){
		if (n<=1){
			if (x==1 && y==1){
				return 1;
			}else if (x==1 && y==2){
				return 2;
			}else if (x==2 && y==2){
				return 3;
			}else{
				return 4;
			}
		}
		
		long rows=(long) Math.pow(2, n)/2;
		int xth=0;
		long oneCount=rows*rows;
		if (x<=rows && y<=rows){
			xth=1;
		}else if (x<=rows && y>rows){
			xth=2;
		}else if (x>rows && y>rows){
			xth=3;
		}else {
			xth=4;
		}
		if (xth==1){
			return (xth-1)*oneCount+solve(y, x, n-1);
		}else if (xth==2){
			long x0=0;
			long y0=rows;
			return (xth-1)*oneCount+solve(x, y-y0, n-1);
		}else if (xth==3){
			long x0=rows;
			long y0=rows;
			return (xth-1)*oneCount+solve(x-x0, y-y0, n-1);
		}else{
			long x0=2*rows+1;
			long y0=rows+1;
			return (xth-1)*oneCount+solve(y0-y,x0-x, n-1);
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long x=in.nextLong();
		long y=in.nextLong();
		System.out.println(solve(x,y, n));
	}

}
