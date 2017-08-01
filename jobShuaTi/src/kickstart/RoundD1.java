package kickstart;


import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;

public class RoundD1 {
	private int solve(int[] Si, int[] Fi, int[] Di, int N,int Ts, int Tf){
		if (Ts>Tf) return 0;
		 
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String parentPath="F:\\codeRepository\\jobShuaTi\\jobShuaTi\\src\\kickstart\\";
		FileReader reader=new FileReader(parentPath+"A-small-practice.in");
		Scanner in=new Scanner(reader);
		int T=in.nextInt();
		for (int i=0;i<T;++i){
			int N=in.nextInt();
			int Ts=in.nextInt();
			int Tf=in.nextInt();
			int[] Si=new int[N-1];
			int[] Fi=new int[N-1];
			int[] Di=new int[N-1];
			for (int j=0;i<N-1;++j){
				Si[j]=in.nextInt();
				Fi[j]=in.nextInt();
				Di[j]=in.nextInt();
			}
			
		}
	}

}
