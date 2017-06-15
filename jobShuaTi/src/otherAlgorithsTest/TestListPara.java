package otherAlgorithsTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TestListPara {
	
	    public List<String> findItinerary(String[][] tickets) {
	        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
	        for(String[] s:tickets){
	            if(!map.containsKey(s[0])){
	                PriorityQueue<String> queue=new PriorityQueue<String>();
	                map.put(s[0],queue);
	            }
	            map.get(s[0]).offer(s[1]);
	        }
	        LinkedList<String> res=new LinkedList<>();
	        dfs("JFK",map,res);
	        return res;
	    }
	    public void dfs(String s,HashMap<String,PriorityQueue<String>> map,LinkedList<String> res){
	    	
	        PriorityQueue<String> queue=map.get(s);
	        while(queue!=null&&!queue.isEmpty()){
	            dfs(queue.poll(),map,res);
	        }
	        System.out.println(res.toString());
	        res.addFirst(s);
	    }
	    public static void main(String[] args){
	    	String[][] teStrings={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
	    	TestListPara testListPara=new TestListPara();
//	    	
//	    	System.out.println(testListPara.findItinerary(teStrings).toString());
	    	int i=1000000000;
	    	i+=10;
	    	System.out.println(i);
	    }
	
}
