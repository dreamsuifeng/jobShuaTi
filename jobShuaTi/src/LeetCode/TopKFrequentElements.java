package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums==null || nums.length==0) return null;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i:nums){
        	map.compute(i, (ke,v)->(v==null) ? 1:v+1);
        }
        for (int i:nums){
        	if (map.containsKey(i)){
        		map.put(i, map.get(i)+1);
        	}else{
        		map.put(i, 1);
        	}
        }
        Iterator<Map.Entry<Integer, Integer>> iter=map.entrySet().iterator();
        PriorityQueue<Map.Entry<Integer, Integer>> queue=new PriorityQueue<>((Map.Entry<Integer, Integer> x, Map.Entry<Integer, Integer> y) ->x.getValue()-y.getValue());
        while(iter.hasNext()){
        	if (queue.size()<k){
        		queue.add(iter.next());
        	}else{
        		Map.Entry<Integer, Integer> tEntry=iter.next();
        		if (tEntry.getValue()>queue.peek().getValue()){
        			queue.poll();
        			queue.add(tEntry);
        		}
        	}
        }
        Iterator<Map.Entry<Integer, Integer>> iterator=queue.iterator();
        LinkedList<Integer> res=new LinkedList<>();
        while(iterator.hasNext()){
        	res.addFirst(iterator.next().getKey());
        }
        return res;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1,1,2,2,3};
		TopKFrequentElements t=new TopKFrequentElements();
		System.out.println(t.topKFrequent(nums, 2).toString());
	}

}
