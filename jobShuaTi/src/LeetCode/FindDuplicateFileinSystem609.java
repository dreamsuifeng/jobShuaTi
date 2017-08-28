package LeetCode;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindDuplicateFileinSystem609 {
	public List<List<String>> findDuplicate(String[] paths) {
	        int n=paths.length;
	        HashMap<String, List<String>> map=new HashMap<>();
	        Pattern pattern=Pattern.compile("(.*)");
	        for (int i=0;i<n;++i){
	        	String tmp=paths[i];
	        	String[] ts=tmp.split(" ");
	        	for (int j=1;j<ts.length;++j){
	        		int s=ts[j].indexOf("(");
	        		String filePath=ts[0]+"/"+ts[j].substring(0, s);
	        		String content=ts[j].substring(s);
	        		if (map.containsKey(content)){
	        			map.get(content).add(filePath);
	        		}else{
	        			List<String> l=new LinkedList<>();
	        			l.add(filePath);
	        			map.put(content,l);
	        		}
	        	}
	        	
	        }
	        return map.values().stream().filter(x->x.size()>1).collect(Collectors.toList());
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
