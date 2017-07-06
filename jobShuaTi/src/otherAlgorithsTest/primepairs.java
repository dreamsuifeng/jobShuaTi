package otherAlgorithsTest;

import java.util.List;
import java.util.Scanner;

public class primepairs {
	private boolean isPrime(int n){
		if (n<=1) return false;
		for (int i=2;i<=(int)Math.sqrt(n);++i){
			if (n%i==0){
				return false;
				
			}
		}
		return true;
	}
	private int primeCount(int n){
		int res=0;
		for (int i=2;i<=n/2;++i){
			if (isPrime(i) && isPrime(n-i)){
				System.out.println(i);
				res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(new primepairs().primeCount(n));
	}

}
