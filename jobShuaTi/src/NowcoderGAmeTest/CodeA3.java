package NowcoderGAmeTest;

import java.util.Scanner;

public class CodeA3 {
	public static String[] solve(int n, int T, int C,int[] t,int[] c, int maxT, int minT,long all,long call){
		String[] res=new String[2];
        if (T <minT){
			double finalc=0.0;
			for (int i=0;i<n;++i){
				finalc+=(t[i]*c[i]-minT*c[i])/(double)(minT-T);
			}
//			System.out.println(finalc);
			if (finalc>C){
				res[0]="Impossible";
			}else{
				res[0]="Possible";
				res[1]=String.format("%.4f", (double)minT);
			}
		}else if (T>maxT){
			double tmp=((double)((long)T*(long)C+all))/(double)(call+C);
//			System.out.println(tmp);
            if (tmp<maxT){
                res[0]="Impossible";
            }else{
                res[0]="Possible";
                res[1]=String.format("%.4f",tmp);
            }
		}
		else{
			if ((T==maxT || T==minT)&& maxT!=minT){
				res[0]="Impossible";
			}else{
				res[0]="Possible";
				res[1]=String.format("%.4f", (double)minT);
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
//		System.out.println(minT+","+maxT);
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
