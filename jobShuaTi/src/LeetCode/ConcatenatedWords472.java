package LeetCode;

import java.time.Year;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords472 {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res=new LinkedList<>();
        Set<String> pre=new HashSet<>();
        Arrays.sort(words,(x,y)->x.length()-y.length());
        for(int i=0;i<words.length;++i){
        	if (canForm(words[i], pre)){
        		res.add(words[i]);
        	}
        	pre.add(words[i]);
        }
        return res;
    }
	private boolean canForm(String word,Set<String> dict){
		if (dict.isEmpty()) return false;
		boolean[] dp=new boolean[word.length()+1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
		    for (int j = 0; j < i; j++) {
			if (!dp[j]) continue;
			if (dict.contains(word.substring(j, i))) {
			    dp[i] = true;
			    break;
			}
		    }
		}
		return dp[word.length()];
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
