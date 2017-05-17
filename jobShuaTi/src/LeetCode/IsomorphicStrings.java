package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        Map<Character, Character> map=new HashMap<>();
        Set<Character> used=new HashSet<>();
        for (int i=0;i<n;++i){
        	char st=s.charAt(i);
        	char tt=t.charAt(i);
        	if (map.containsKey(st)){
        		if (map.get(st).equals(tt)){
        			continue;
        		}else{
        			return false;
        		}
        	}else {
				if (!used.contains(tt)){
					map.put(st, tt);
					used.add(tt);
				}else {
					return false;
				}
			}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
