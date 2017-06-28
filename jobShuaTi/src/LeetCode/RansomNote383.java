package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {
	public static boolean canConstruct(String ransomNote, String magazine) {
        char[] rans=ransomNote.toCharArray();
        char[] mags=magazine.toCharArray();
        if (rans.length>mags.length) return false;
        Map<Character, Integer> map=new HashMap<>();
        for (char c:mags){
        	map.compute(c, (k,v)->(v==null ? 1:(v+1)));
        }
        for (char c:rans){
        	if (map.containsKey(c) && map.get(c)>0){
        		map.put(c, map.get(c)-1);
        	}else{
        		return false;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canConstruct("aac", "abac"));
	}

}
