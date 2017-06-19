package NowcoderGAmeTest;

import java.util.Scanner;

public class CodeA3 {
	public static String[] solve(int n, int T, int C,int[] t,int[] c, int maxT, int minT,long all,long call){
		String[] res=new String[2];
        if (T==minT || T==maxT) {
            res[0]="Impossible";
        }else if (T <minT){
			double finalc=0.0;
			for (int i=0;i<n;++i){
				finalc+=(t[i]*c[i]-minT*c[i])/(minT-T);
			}
			if (finalc>C){
				res[0]="Impossible";
			}else{
				res[0]="Possible";
				res[1]=String.format("%.4f", (double)minT);
			}
		}else{
            double finalC=0.0;
            for (int i=0;i<n;++i){
				finalC+=(t[i]*c[i]-maxT*c[i])/(maxT-T);
			}
            if (finalC>C){
                res[0]="Impossible";
            }else{
                res[0]="Possible";
                double tmp=((double)(T*C+all))/(double)(call+C);
                res[1]=String.format("%.4f",tmp);
            }
		}
		return res;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int T=in.nextInt();
		int C=in.nextInt();
		int[] t=new int[n];
		int[] c=new int[n];
		for(int i=0;i<n;++i){
			t[i]=in.nextInt();
			c[i]=in.nextInt();
		}
		int maxT=Integer.MIN_VALUE;
		int minT=Integer.MAX_VALUE;
		long all=0l;
		long call=0l;
		for (int i=0;i<n;++i){
			maxT=Math.max(t[i], maxT);
			minT=Math.min(minT, t[i]);
			all+=t[i]*c[i];
			call+=c[i];
		}
		if (minT<T && maxT>T){
//			System.out.println(1);
			System.out.println("Impossible");
		}
		else{
			String[] res=solve(n, T, C, t, c, maxT, minT, all, call);
			if (res[0].equals("Impossible")){
				System.out.println("Impossible");
			}else{
				System.out.println("Possible");
				System.out.println(res[1]);
			}
		}
		
	}
}
