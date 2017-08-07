package LeetCode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LongestWordinDictionarythroughDeleting524 {
	
	public boolean contains(String s1,String s2){
		int i=0,j=0;
		while (i<s1.length() && j<s2.length()){
			if (s1.charAt(i)==s2.charAt(j)){
				i++;
				j++;
			}else{
				i++;
			}
		}
		return j==s2.length();
	}
	public String findLongestWord(String s, List<String> d) {
        Collections.sort(d,(x,y)->(x.length()!=y.length() ? (y.length()-x.length()):x.compareTo(y)));
        for (String c:d){
        	if (contains(s, c)){
        		return c;
        	}
        }
        return "";
    }
}
