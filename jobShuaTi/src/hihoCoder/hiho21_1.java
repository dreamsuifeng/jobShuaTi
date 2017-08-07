package hihoCoder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class hiho21_1 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		long k=in.nextLong();
		long mod=1000000007l;
		long[] d=new long[N];
		for (int i=0;i<N;++i){
			d[i]=in.nextLong();
		}
		Arrays.sort(d);
		int minIndex=0, maxIndex=N-1,ans=0;
		int[] pow=new int[N];
		pow[0]=1;
		for (int i=1;i<pow.length;++i){
			pow[i]=(int) ((pow[i-1]*2)%mod);
		}
		while (minIndex<=maxIndex){
			if(d[minIndex]+d[maxIndex]<=k){
				ans=(int) ((ans+pow[maxIndex-minIndex])%mod);
				minIndex++;
			}else {
				maxIndex--;
			}
		}
		System.out.println(ans);
	}
}
