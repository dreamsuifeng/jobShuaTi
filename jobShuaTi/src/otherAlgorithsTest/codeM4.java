package otherAlgorithsTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.sql.rowset.Joinable;

public class codeM4 {
	public static String solve(LinkedList<String> res, int[] a, int[] b, int n, int i, Set<Integer> exindex){
		if (i==n-1) return "true";
		if (i>=n || i<0) return  "false";
		if (exindex.contains(i)) return "circle";
		exindex.add(i);
		String t=solve(res,a, b, n, i+a[i], exindex);
		if (t.equals("true")){
			res.addFirst("a");
			return "true";
		}else if (t.equals("Infinity!")){
			return "Infinity!";
		
		}else{
			
			String tb=solve(res, a, b, n, i+b[i], exindex);
			if (tb.equals("true") && t.equals("circle")){
				return "Infinity!";
			}else if(tb.equals("true") && t.equals("false")){
				res.addFirst("b");
				return "true";
			}else if (tb.equals("false") || tb.equals("circle")){
				return "false";
			}
		}
		exindex.remove(i);
		return "false";
	}

	public static String join(LinkedList<String> s){
		StringBuffer sb=new StringBuffer();
		while(!s.isEmpty()){
			sb.append(s.poll());
		}
		return sb.toString();
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
        LinkedList<String> opt=new LinkedList<>();
        String flag=solve(opt,a, b,n, 0, new HashSet<Integer>());
        if (flag.equals("true")){
        	System.out.println(join(opt));	
        }else if (flag.equals("false")){
        	System.out.println("No solution!");
        }else{
        	System.out.println("Infinity!");
        }
//		}
	}

}
