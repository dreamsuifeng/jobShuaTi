package hihoCoder;

import java.util.Scanner;

public class Challenge30_2 {
	public static long fastPow(long n,long mod,long k){
		long r=1;
		while (k>0){
			if ((k&1)==1) r=(r*n)%mod;
			n=(n*n)%mod;
			k>>=1;
		}
		return r;
	}
	
	public static double[] solve(long a,long b,long c,long d){
		double P=(Math.pow(b, 2)-3*a*c+12*d)/9;
		double Q=(2*Math.pow(b, 3)-9*b*c*d+27*Math.pow(c, 2)+27*Math.pow(a, 2)*d-72*b*d)/54;
		double D=Math.sqrt(Math.pow(Q, 2)-Math.pow(P, 3));
		double u=Math.pow(Q+D, 1.0/3);
		double v=P/u;
		double m2=Math.sqrt(Math.pow(a, 2)/4-2*b/3+u+v);
		double S4=Math.pow(a, 2)/4-4*b/3-u-v;
		double T4=(-Math.pow(a, 3)+4*a*b-8*c)/(4*m2);
		double[] ans=new double[4];
		
		for (int i=1;i<5;++i){
			int aa=i/2;
			double r=-a/4+(Math.pow(-1,aa)/2)*m2+Math.pow(-1, i+1)*Math.sqrt(S4+Math.pow(-1, aa)*T4);
			ans[i-1]=r;
			System.out.println(r);
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		long mod=(long) (1e9+7);
		int T=sc.nextInt();
		while (T-->0){
			long n=sc.nextLong();
			long a=sc.nextLong();
			long b=sc.nextLong();
			long c=sc.nextLong();
			long d=sc.nextLong();
			long ans=0;
			
			double[] res=solve(a, b, c, d);
			ans=(ans+fastPow((long)res[0], mod, n))%mod;
			ans=(ans+fastPow((long)res[1], mod, n))%mod;
			ans=(ans+fastPow((long)res[2], mod, n))%mod;
			ans=(ans+fastPow((long)res[3], mod, n))%mod;
			System.out.println(ans);
		}
		
	}

}
