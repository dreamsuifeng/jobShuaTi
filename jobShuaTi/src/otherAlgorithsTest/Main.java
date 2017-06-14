package otherAlgorithsTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int solve(String[] data1, int n){
        int res=-1;
        if (n==0 || data1==null || data1.length==0) return -1;
        Map<String,Integer> used=new HashMap<>();
        int step=1;
        for(String s:data1){
//        	System.out.println(s);
        	if (s.equals("?")){
        		if (used.containsKey("?")){
        			used.put("?", used.get("?")+1);
        		}else{
        			used.put("?", 1);
        		}
        	}else{
        		String[] tmp=s.split(" ");
        		if (tmp[0].equals("O")){
        			if (!used.containsKey(tmp[1]) && !used.containsKey("?")){
        				return step;
        			}else if(used.containsKey(tmp[1]) && !used.containsKey("?")){
        					int Ivalue=used.get(tmp[1]);
        					if (Ivalue>0){
        						used.put(tmp[1], Ivalue-1);
        					}else{
        						return step;
        					}
        			}else if (!used.containsKey(tmp[1]) && used.containsKey("?")){
        					
        					int t=used.get("?");
        					if (t==0){
        						return step;
        						
        					}else {
        						used.put(tmp[1], 0);
								used.put("?", t-1);
							}
    				}else{
    					int Ivalue=used.get(tmp[1]);
    					int t=used.get("?");
    					if (Ivalue>0){
    						used.put(tmp[1], Ivalue-1);
    					}else{
    					
	    					if (t==0){
	    						return step;
	    						
	    					}else {
	    						used.put(tmp[1], 0);
								used.put("?", t-1);
							}
        			}
        		}
        		}
        		if (tmp[0].equals("I")){
        			if (used.containsKey(tmp[1])){
        				int uscount=used.get(tmp[1]);
        				if (uscount>0){
        					return step;
        				}else{
        					used.put(tmp[1], uscount+1);
        				}
        			}else{
        				used.put(tmp[1], 1);
        			}
        		}
        		
        	}
        	step++;
        }
        return res;
    }
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = Integer.parseInt(in.nextLine());
            String[] data = new String[m];
            for(int i=0;i<m;i++){
            	data[i]=in.nextLine();
            }
            System.out.println(solve(data, m));
        }
	}
}
