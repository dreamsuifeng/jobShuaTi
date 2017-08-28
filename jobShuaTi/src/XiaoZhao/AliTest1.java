package XiaoZhao;


import java.util.*;
public class AliTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long k=in.nextLong();
		long i=1;
		long sum=0;
		StringBuilder sb=new StringBuilder();
		while (sum<k){
			sb.append(i);
			sum+=sb.length();
			i++;
		}
		sum-=sb.length();
		long index=k-sum;
		System.out.println(""+sb.charAt((int) index-1));
		
	}

}
