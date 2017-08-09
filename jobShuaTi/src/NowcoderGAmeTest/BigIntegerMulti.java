package NowcoderGAmeTest;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigIntegerMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s1=in.next();
		String s2=in.next();
		BigDecimal i1=new BigDecimal(s1);
		BigDecimal i2=new BigDecimal(s2);
		BigDecimal ans=i1.multiply(i2);
		System.out.println(ans);
	}	

}
