package otherAlgorithsTest;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class codeM4 {
	public static String solve(int[] a, int[] b, int n, int i, String tmp, Set<Integer> exindex){
		if (i==n-1) return tmp;
		if (i>=n || i<0) return  "“No solution!”";
		if (exindex.contains(i)) return "“Infinity!”";
		String tmp1="“No solution!”";
		exindex.add(i);
		if (a[i]!=0){
			
			tmp1=solve(a, b, n, i+a[i], tmp+"a", exindex);
//			exindex.remove(i);
		}
		if (!tmp1.equals("“No solution!”")){
			return tmp1;
		}else{
			
			String tmp2="“No solution!”";
			if(b[i]!=0){
//				exindex.add(i);
				tmp2=solve(a, b, n, i+b[i], tmp+"b", exindex);
				exindex.remove(i);
			}
			if (!tmp2.equals("“No solution!”")){
				return tmp2;
			}else{
				return "“No solution!”";
			}
		}
	
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++){
        	a[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
        	b[i]=in.nextInt();
        }
        System.out.println(solve(a, b,n, 0, "", new HashSet<Integer>()));
//		}
	}

}
