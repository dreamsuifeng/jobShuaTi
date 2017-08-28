package templates;

import java.util.Scanner;

public class ToutiaoHuoAnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long x=in.nextLong();
		long k=in.nextLong();
		long bitNum=1;
		long ans=0;
		while (k>0){
			if ((x & bitNum)==0){
				ans+=(bitNum*(k&1));
				k>>=1;
			}
			bitNum<<=1;
		}
		System.out.println(ans);
	}

}
