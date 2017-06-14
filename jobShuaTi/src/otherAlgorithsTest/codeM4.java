package otherAlgorithsTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class codeM4 {
	public  boolean solve(LinkedList<String> res, int[] a, int[] b, int n, int i, Set<Integer> exindex){
		if (i==n-1) return true;
		if (i>=n || i<0) return  false;
		if (exindex.contains(i)) return false;
		exindex.add(i);
		if (a[i]!=0 ){
			boolean t=solve(res,a, b, n, i+a[i], exindex);
			if (t){
				res.addFirst("a");
				return true;
			}
			else{
				if (b[i]!=0 && solve(res, a, b, n, i+b[i], exindex)){
					res.addFirst("b");
					return true;
				}
			}
		}
		exindex.remove(i);
		return false;
		
	}
	public  String join(LinkedList<String> s){
		StringBuffer sb=new StringBuffer();
		while(!s.isEmpty()){
			sb.append(s.poll());
		}
		return sb.toString();
	}
	private boolean circle(int i, int[] a, int b[],int biaoji, int step){
		if (i<0 || i>=a.length) return false;
		if (step>0 && i==biaoji) return true;
		return circle(i+a[i], a, b, biaoji,step+1) || circle(i+b[i], a, b, biaoji,step+1);
	}
	public boolean isCircle(char[] ans, int[] a, int[] b){
		int start=0;
		for (int i=0;i<ans.length;++i){
			if (ans[i]=='a'){
				if(circle(i, a, b, i, 0)){
					return true;
				}
			}
			if (ans[i]=='a') start+=a[start];
			else start+=b[start];
			
		}
		return false;
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
        codeM4 t=new codeM4();
        boolean flag=t.solve(opt,a, b,n, 0, new HashSet<Integer>());
        if (flag){
        	String answer=t.join(opt);
        	if (t.isCircle(answer.toCharArray(), a, b)){
        		System.out.print("Infinity!");
        	}else{
        		System.out.println(answer);
        	}
        }else{
        	System.out.println("No solution!");
        }
//		}
	}

}
