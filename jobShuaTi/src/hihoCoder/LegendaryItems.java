package hihoCoder;
import java.util.Scanner;
import java.math.*;
public class LegendaryItems{
    static double computeNUm(int Pini, int P, int Q, int N, int step, double l){
		if(N==0){
			return l;
		}
		else if (N>0 && P>=100){
			return computeNUm(Pini, (int) (Pini/Math.pow(2, step+1)), Q, N-1, step+1, l+1);
		}
		else{
			return (double) P/100*computeNUm(Pini, (int) (Pini/Math.pow(2, step+1)), Q, N-1, step+1, l+1)+(double) (100-P)/100*computeNUm(Pini, P+Q, Q, N, step, l+1);
		}
	}
    static double compute2(int N,int P,int Q,int Pint){
    	double resultExpected=0.0;
    	for(int i=0;i<N;++i){
    		int s=1;
    		double tempEx=(double)P/100;
    		double tempNotex=(double) (100-P)/100;
    		P+=Q;
    		while(P<100){
    			s+=1;
    			tempEx+=s*tempNotex*(double)P/100;
    			tempNotex*=(double)(100-P)/100;
    			P+=Q;
    		}
    		tempNotex*=(s+1);
    		tempEx+=tempNotex;
    		resultExpected+=tempEx;
    		Pint=(int)Pint/2;
    		P=Pint;
    	}
    	return resultExpected;
    }
	public static void main(String[] args){
	    Scanner in=new Scanner(System.in);
	    while(in.hasNext()){
	        int P=in.nextInt();
	        int Q=in.nextInt();
	        int N=in.nextInt();
	        double result=LegendaryItems.compute2(N,P,Q,P);
	        System.out.println(String.format("%.2f",result));
	    }
	}
}