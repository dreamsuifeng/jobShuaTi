package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long n=in.nextLong();
		long ans=0;
		for (long i=1l;i<=Math.sqrt(n);++i){
			if (i%2!=0){
				long t=n/i;
				int c=(int) (Math.log10(t)/Math.log10(2));
				ans+=i*(c+1);
			}
		}
		System.out.println(ans);
		int s=(int) Math.sqrt(n);
		if ((n-s)%2!=0) n-=1;
		long sum=(s+1+n)*(n-s)/2;
		long count=(n-s)/2;
		if ((s+1)%2==0){
			long add=(sum+count)/2;
			ans+=add;
		}else{
			long add=(sum-count)/2;
			ans+=add;
		}
		System.out.println(ans);
	

}
}
