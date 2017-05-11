package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	private Map<Integer, Integer> map=new HashMap<>();
	private LinkedList<Integer> keyList=new LinkedList<>();
	private int Capa;
	private int preCount=0;
    public LRUCache(int capacity) {
        this.Capa=capacity;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)){
    		keyList.remove((Object)key);
    		keyList.add(key);
    		return map.get(key);
    	}else{
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
        if (preCount<=this.Capa && map.containsKey(key)){
        			map.put(key, value);
        			keyList.remove((Object)key);
        			keyList.add(key);
        	}
        else if (preCount==this.Capa && !map.containsKey(key)){
        	map.remove(keyList.poll());
        	map.put(key, value);
        	keyList.add(key);
        }else{
        	map.put(key, value);
        	keyList.add(key);
        	preCount++;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
