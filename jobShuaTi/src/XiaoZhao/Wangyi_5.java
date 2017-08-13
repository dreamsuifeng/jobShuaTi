package XiaoZhao;

import java.util.Scanner;

public class Wangyi_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
		String[] d=in.nextLine().split(" ");
		StringBuffer res=new StringBuffer();
		int i=n-1;
		while (i>=0){
			System.out.print(d[i]+" ");
			i-=2;
		}
		int j=-1;
		if (i==-1){
			j=0;
		}else{
			j=1;
		}
		while (j<n){
			System.out.print(d[j]);
			if (j<n-2){
				System.out.print(" ");
			}
			j+=2;
		}
		
	
		
	}	

}
