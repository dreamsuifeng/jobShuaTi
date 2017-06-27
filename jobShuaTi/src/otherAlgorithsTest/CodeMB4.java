package otherAlgorithsTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeMB4 {
	public static String solve(long a,long b,long c,long k){
		a=a%k;
		long s=a%b;
		long i=s;
		long m=1;
		Set<Long> set=new HashSet<>();
		while (m<=k/a){
			set.add(i);
			if (i%b==c){
				return "yes";
			}
			i=(i+m*a)%b;
			if (set.contains(i)) break;
            m++;
		}
		return "no";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for (int i=0;i<T;i++){
			long a=in.nextLong();
			long b=in.nextLong();
			long c=in.nextLong();
			long k=in.nextLong();
			System.out.println(solve(a, b, c, k));
		}
	}

}
