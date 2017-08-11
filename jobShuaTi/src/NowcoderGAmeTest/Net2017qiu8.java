package NowcoderGAmeTest;

import java.util.Scanner;

public class Net2017qiu8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int y1=in.nextInt();
		int y2=in.nextInt();
		int y3=in.nextInt();
		int y4=in.nextInt();
		int A=(y1+y3)/2;
		int B=(y2+y4)/2;
		int C=(y4-y2)/2;
		if (A*2==y1+y3 && B*2==y2+y4 && C*2==y4-y2 && A>=0 && B>=0 && C>=0){
			System.out.println(A+" "+B+" "+C);
		}else{
			System.out.println("No");
		}
		
	}

}
