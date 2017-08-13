package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] d=new int[n];
		for (int i=0;i<n;++i){
			d[i]=in.nextInt();
			
		}
		int i=0,j=n-1;
		int fore=d[i];
		int back=d[j];
		int ans=0;
		while (i<j){
			if (fore==back){
				i++;
				j--;
				
				fore=d[i];
				back=d[j];
			}else if (fore<back){
				i++;
				fore+=d[i];
				ans++;
			}else{
				j--;
				back+=d[j];
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
