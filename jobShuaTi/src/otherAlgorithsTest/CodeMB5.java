package otherAlgorithsTest;

import java.util.Scanner;

public class CodeMB5 {
	public static String solve(int n, String t){
		 StringBuffer sb=new StringBuffer();
		for (int i=2;i<=16;++i){
            for(int j=1;j<=n;++j){
                sb.append(Integer.toString(j, i));
            }
            String tmp=sb.toString();
            if (tmp.contains(t)){
                return "yes";
            }
        }
		return "no";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
        in.nextLine();
		String t=in.nextLine();
        t=t.toLowerCase();
//        System.out.println(t);
        System.out.println(solve(n, t));
        

	}

}
