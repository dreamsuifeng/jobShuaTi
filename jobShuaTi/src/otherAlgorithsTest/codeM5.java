package otherAlgorithsTest;

import java.util.Scanner;

public class codeM5 {
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int l=in.nextInt();
        int r=in.nextInt();
        int[] res=new int[9];
        for (int i=l;i<=r;++i){
            
            int sq= (int)Math.sqrt(i);
            for (int j=1;j<=sq;++j){
                if (i%j==0) {
                    String t=String.valueOf(j);
                    res[Integer.parseInt(""+t.charAt(0))-1]++;
                    String ts=String.valueOf(i/j);
                    res[Integer.parseInt(""+ts.charAt(0))-1]++;
                }
            }
           
            if (sq*sq==i){
              	res[Integer.parseInt(""+String.valueOf(sq).charAt(0))-1]--;
            }
            
        }
        for (Integer i:res){
            System.out.println(i);
        }
    }
}
