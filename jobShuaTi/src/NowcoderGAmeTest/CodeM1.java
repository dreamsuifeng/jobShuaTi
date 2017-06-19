package NowcoderGAmeTest;
import java.util.*;
public class CodeM1 {
	public static double solve(int n, double[] iniv, double[] diffv,double u,double v){
		if (n==0 || n==1) return 0.0;
		double res=0.0;
		for(int i=0;i<n;++i){
			
			double t=0.0;
			for (int j=1;j<=n;++j){
				double vi=iniv[i]-(j-1)*diffv[i];
				t+=n*u/(vi-v);
			}
			
			res+=t/n;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		double v=in.nextDouble();
		double u=in.nextDouble();
		double[] iniv=new double[n];
		double[] diffv=new double[n];
		for (int i=0;i<n;++i){
			iniv[i]=in.nextDouble();
		}
		for (int i=0;i<n;++i){
			diffv[i]=in.nextDouble();
		}
		double res=solve( n,iniv, diffv,u,v);
		System.out.println(String.format("%.3f", res));
	}

}
