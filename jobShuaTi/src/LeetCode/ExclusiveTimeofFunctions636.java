package LeetCode;

import java.util.List;

public class ExclusiveTimeofFunctions636 {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] ret = new int[n];
    	int ptime = -1;
    	int[] stack = new int[logs.size()+2];
    	int p = 0;
        for(int i = 0;i < logs.size();i++){
        	String[] sp = logs.get(i).split(":");
        	int id = Integer.parseInt(sp[0]);
        	int time = Integer.parseInt(sp[2]);
        	if(p > 0){
        		ret[stack[p-1]] += time - ptime - 1;
        	}
        	if(sp[1].equals("start")){
        		stack[p++] = id;
        		ret[id]++;
        	}else{
        		ret[id]++;
        		p--;
        	}
        	ptime = time;
        }
        return ret;
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
