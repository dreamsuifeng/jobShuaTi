package NowcoderGAmeTest;

import java.util.Arrays;
import java.util.Scanner;

public class tuQiPan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char[][] qipan=new char[n][n];
		in.nextLine();
		for (int i=0;i<n;++i){
			char[] t=in.nextLine().toCharArray();
			qipan[i]=Arrays.copyOf(t, n);
			
		}
		int ans=0;
		for (int i=0;i<n;++i){
			int tmp=1;
			for (int j=1;j<n;++j){
				
				if (qipan[j][i]==qipan[j-1][i]){
					tmp++;
				}else{
					ans=Math.max(ans, tmp);
					tmp=1;
				}
			}
			ans=Math.max(ans, tmp);
		}
		
		System.out.println(ans);
		
	}

}
