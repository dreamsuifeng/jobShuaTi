package otherAlgorithsTest;

import java.util.Scanner;

public class geohashCode {
	public String help(int n,int begin,int end,int k){
		if (k==0) return "";
		int mid=(begin+end)/2;
		if (n<mid){
			return "0"+help(n, begin, mid, k-1);
		}else{
			return "1"+help(n, mid, end, k-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(new geohashCode().help(n, -90, 90, 6));
	}	

}
