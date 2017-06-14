package otherAlgorithsTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class codeM5 {
	public static int[] solve(int l, int r){
		Map<Integer, int[]> map=new HashMap<>();
		int[] res=new int[9];
		
		for (int i=l;i<=r;++i){
			int[] tmp=new int[9];
	            int sq= (int)Math.sqrt(i);
	      
	            for (int j=sq;j>=1;--j){
	                if (i%j==0) {
	                	if(map.containsKey(i)){
	                		tmp=map.get(i);
	                		break;
	                	}else{
	                		String t=String.valueOf(j);
		                    tmp[Integer.parseInt(""+t.charAt(0))-1]++;
		                    String ts=String.valueOf(i/j);
		                    tmp[Integer.parseInt(""+ts.charAt(0))-1]++;
	                	}
	                    
	                }
	            }
	            
	           
	            if (sq*sq==i){
	              	tmp[Integer.parseInt(""+String.valueOf(sq).charAt(0))-1]--;
	            }
	            for (int k=0;k<9;k++){
	            	res[k]+=tmp[k];
	            }
	            if (!map.containsKey(i)){
	            	map.put(i,tmp);
	            }
	            
	        }
		 return res;
	}
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int l=in.nextInt();
        int r=in.nextInt();
        int[] res=solve(l, r);
       
        for (Integer i:res){
            System.out.println(i);
        }
    }
}
