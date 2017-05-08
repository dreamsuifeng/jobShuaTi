package hihoCoder;
import java.util.ArrayList;
import java.util.Scanner;

public class hiho2 {
	static void computePorb(float[] probs,int M, int N, int step, double tempProb, ArrayList<Double> prob){
		if (M==0){
			int i=step;
			while (i<N){
				tempProb*=(1-probs[step]);
				i++;
			}
			prob.add(tempProb);
		}else  if(M>0 && step<N) {
			computePorb(probs, M-1, N, step+1, tempProb*probs[step], prob);
			computePorb(probs, M, N, step+1, tempProb*(1-probs[step]), prob);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inScanner =new Scanner(System.in);
		while (inScanner.hasNext()) {
			int N=inScanner.nextInt();
			int M=inScanner.nextInt();
			int i=0;
			float[] pro=new float[N];
			while(i<N){
				pro[i]=inScanner.nextFloat();
				i++;
			}
		ArrayList<Double> result=new ArrayList<Double>();
		computePorb(pro, M, N, 0, 1.0, result);
		double pr=0.0;
		for (int i1=0;i1<result.size();++i1){
			pr+=result.get(i1);
		}
		System.out.println(String.format("%.3f",pr));
	}

}
}
