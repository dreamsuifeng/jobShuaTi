package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class wordLadderIITwo {
	List<List<String>> results;
	List<String> list;
	Map<String,List<String>> map;
	
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results= new ArrayList<List<String>>();
        if (dict.size() == 0)
			return results;
        
        int curr=1,next=0;	        
        boolean found=false;	        
        list = new LinkedList<String>();	       
		map = new HashMap<String,List<String>>();
		
		Queue<String> queue= new ArrayDeque<String>();
		Set<String> unvisited = new HashSet<String>(dict);
		Set<String> visited = new HashSet<String>();
		
		queue.add(start);			
		unvisited.add(end);
		unvisited.remove(start);
		//BFS
		while (!queue.isEmpty()) {
		   
			String word = queue.poll();
			curr--;				
			for (int i = 0; i < word.length(); i++){
			   StringBuilder builder = new StringBuilder(word); 
				for (char ch='a';  ch <= 'z'; ch++){
					builder.setCharAt(i,ch);
					String new_word=builder.toString();	
					if (unvisited.contains(new_word)){
						//Handle queue
						if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
							next++;
							queue.add(new_word);
						}
						
						if (map.containsKey(new_word))//Build Adjacent Graph
							map.get(new_word).add(word);
						else{
							List<String> l= new LinkedList<String>();
							l.add(word);
							map.put(new_word, l);
						}
						
						if (new_word.equals(end)&&!found) found=true;		
													
					}

				}
			}
			if (curr==0){
				if (found) break;
				curr=next;
				next=0;
				unvisited.removeAll(visited);
				visited.clear();
			}
		}//End While

		backTrace(end,start);
		
		return results;        
    }
    private void backTrace(String word,String start){
    	if (word.equals(start)){
    		list.add(0,start);
    		results.add(new ArrayList<String>(list));
    		list.remove(0);
    		return;
    	}
    	list.add(0,word);
    	if (map.get(word)!=null)
    		for (String s:map.get(word))
    			backTrace(s,start);
    	list.remove(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
