package hihoCoder;

import java.util.Scanner;

public class BaiduT2 {
	static void findNsamples(int[][] Samples, String[][] Ttests){
		
	}
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		while (in.hasNext()){
			int Ns=in.nextInt();
			int[][] sample=new int[Ns][2];
			for(int i=0;i<Ns;++i){
				sample[i][0]=in.nextInt();
				sample[i][1]=in.nextInt();
				
			}
			int Tn=in.nextInt();
			String[][] tTests=new String[Tn][];
			for (int j=0;j<Tn;++j){
				tTests[j]=in.next().split(" ");
			}
		}
	}
}
