package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomDuplicatesallowed381 {
	Map<Integer, Integer> map;
	List<Integer> data;
	/** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesallowed381() {
        map=new HashMap<Integer, Integer>();
        data=new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	data.add(val); 
        if (map.containsKey(val)){
        	map.put(val, map.get(val)+1);  	
        	return false;
        }else{
       
        	map.put(val, 1);
        	return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val) && map.get(val)>1){
        	map.put(val, map.get(val)-1);
        	data.remove(val);
        	return true;
        }else {
        	if (map.containsKey(val)){
        		map.remove(val);
        		data.remove(val);
        		return true;
        	}else {
				return false;
			}
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random r=new Random();
        return data.get(r.nextInt(data.size()));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
