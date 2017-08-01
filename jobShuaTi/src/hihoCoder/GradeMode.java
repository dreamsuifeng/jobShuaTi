package hihoCoder;

import java.util.Scanner;

public class GradeMode { 
	public static long[] extend_gcd(long a,long b){  
        long ans;  
        long[] result=new long[3];  
        if(b==0)  
        {  
            result[0]=a;  
            result[1]=1;  
            result[2]=0;  
            return result;  
        }  
        long [] temp=extend_gcd(b,a%b);  
        ans = temp[0];  
        result[0]=ans;  
        result[1]=temp[2];  
        result[2]=temp[1]-(a/b)*temp[2];  
        return result;  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long a=in.nextLong();
		long b=in.nextLong();
		long p=in.nextLong();
		long[] res=extend_gcd(b, p);
		int x=(int) (res[1]>0 ? res[1]:res[1]+p);
//		System.out.println(res[0]+","+res[1]+","+res[2]);
		System.out.println((a*x)%p);

	}

}
