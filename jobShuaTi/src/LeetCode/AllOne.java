package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AllOne {
	HashMap<String, Integer> map;
	 /** Initialize your data structure here. */
    public AllOne() {
       map=new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        map.compute(key, (k,v)->v==null ? 1:v+1);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        map.compute(key, (k,v)->v!=null ? v-1:0);
        if (map.get(key)==0){
        	map.remove(key);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	if (map.size()==0) return "";
        ArrayList<Map.Entry<String, Integer>> l=new ArrayList<>(map.entrySet());
        Collections.sort(l,(x,y)->y.getValue()-x.getValue());
        return l.get(0).getKey();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	if (map.size()==0) return "";
    	ArrayList<Map.Entry<String, Integer>> l=new ArrayList<>(map.entrySet());
        Collections.sort(l,(x,y)->x.getValue()-y.getValue());
        return l.get(0).getKey();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
