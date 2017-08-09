package NowcoderGAmeTest;

import java.util.Arrays;
import java.util.Scanner;



public class pindodo3 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] h=new int[n];
		for (int i=0;i<n;++i){
			h[i]=in.nextInt();
		}
		int m=in.nextInt();
		int[] w=new int[m];
		for (int i=0;i<m;++i){
			w[i]=in.nextInt();
			
		}
		
		Arrays.sort(h);
		Arrays.sort(w);
		int ans=0;
		int i=0,j=0;
		while (i<n && j<m){
			if (h[i]<=w[j]){
				ans++;
				i++;
				j++;
			}else {
				j++;
			}
		}
		System.out.println(ans);
		
	}
}
