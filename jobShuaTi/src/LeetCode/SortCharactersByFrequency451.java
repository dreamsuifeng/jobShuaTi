package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency451 {
	public static String frequencySort(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for (char c:s.toCharArray()){
        	map.compute(c, (k,v)->v==null ? 1:v+1);
			}
        List<Map.Entry<Character, Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(x,y)->y.getValue()-x.getValue());
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<list.size();++i){
        	for (int j=0;j<list.get(i).getValue();++j){
        		sb.append(list.get(i).getKey());
        	}
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(frequencySort("abcdaaa"));
	}

}
