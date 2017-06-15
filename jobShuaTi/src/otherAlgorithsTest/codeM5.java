package otherAlgorithsTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeM5 {
	public static int[] solve(int l, int r){
		int[] res=new int[9];
		res[0]=r-l+1;
//		System.out.println(1+","+res[0]);
		for (int i=2;i<=r;++i){
			int count=0;
			if (i>=l){
				count=r/i;
			}else{
				count=(r-l+l%i)/i+(l%i==0 ? 1:0);
			}
//			System.out.println(i+","+count);
			int index=i/(int)Math.pow(10, (int)Math.log10(i));
			res[index-1]+=count;
		}
		 return res;
	}
	public static int[] solve1(int l, int r){
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
		return res;
	}
	public static int[] solve2(int l, int r){
		int[] res=new int[9];
		for (int i=1;i<=9;++i){
			int count=0;
			int j=i;
			int step=1;
			while(j<=r){
				int k=j;
				int front=Math.min(j+step-1, r);
				while(k<=front && k>0){
					if (k>=l){
						count+=r/k;
					}else{
						count+=((r-l+l%k)/k)+(l%k==0 ? 1:0);
					}
					k++;
				}
				step*=10;
				j=i*step;
				
			}
			res[i-1]+=count;
		}
		 return res;
		
	}
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int l=in.nextInt();
        int r=in.nextInt();
        int[] res=solve(l, r);
//        int[] res2=solve1(l, r);
       
        for (int i=0;i<9;++i){
//            System.out.print(res[i]+" "+res2[i]+"\n");
        	System.out.println(res[i]);
        }
    }
}
