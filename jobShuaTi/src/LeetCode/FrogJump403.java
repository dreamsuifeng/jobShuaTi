package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump403 {
	public boolean canCross(int[] stones) {
		if (stones==null || stones.length==0 || stones.length==1) return true;
        int n=stones.length;
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);;
        if (stones[0]+1!=stones[1]){
        	return false;
        }
        for (int i = 1; i < stones.length; i++) {
        	map.put(stones[i], new HashSet<Integer>() );
        }
        for (int i = 0; i < stones.length - 1; i++) {
        	int stone = stones[i];
        	for (int step : map.get(stone)) {
        		int reach = step + stone;
        		if (reach == stones[stones.length - 1]) {
        			return true;
        		}
        		HashSet<Integer> set = map.get(reach);
        		if (set != null) {
        		    set.add(step);
        		    if (step - 1 > 0) set.add(step - 1);
        		    set.add(step + 1);
        		}
        	}
        }
        
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
