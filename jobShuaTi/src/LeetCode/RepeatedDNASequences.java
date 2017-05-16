package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequences {
	 public static List<String> findRepeatedDnaSequences(String s) {
	        HashSet<String> res=new HashSet<>();
	        HashMap<String, Integer> map=new HashMap<>();
	        int n=s.length();
	        if (n<=10) return new LinkedList<>(res);
	        for (int i=0;i<n-9;++i){
	        	String tmp=s.substring(i,i+10);
	        	if (map.containsKey(tmp)){
	        		res.add(tmp);
	        	}else{
	        		map.put(tmp, 1);
	        	}
	        }
	        return new LinkedList<>(res);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(string));;
	}

}
