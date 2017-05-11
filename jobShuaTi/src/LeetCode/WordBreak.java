package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreakhelp(String s, Set<String> wordDict){
		if (wordDict.contains(s)) return true;
		for (int i=1;i<=s.length();++i){
			String tmp=s.substring(0,i);
			if (wordDict.contains(tmp)){
				wordDict.remove(tmp);
				if (wordBreakhelp(s.substring(i), wordDict)){
			
				return true;
				}else{
//					wordDict.add(tmp);
				}
			}
		}
		return false;
	}
//	public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordSet= new HashSet<>(wordDict);
//        return wordBreakhelp(s, wordSet);
//    }
	public boolean wordBreak(String s, List<String> wordDict ){
		Set<String> wordSet= new HashSet<>(wordDict);
		boolean[] dp=new boolean[s.length()+1];
		dp[0]=true;
		for (int i=1;i<dp.length;++i){
			for (int j=0;j<i;++j){
				if (dp[j] && wordSet.contains(s.substring(j,i))){
					dp[i]=true;
				}
			}
		}
//		for (boolean b : dp) {
//			System.out.print(b+",");
//		}
		return dp[s.length()];
	}
	HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

	public List<String> wordBreak(String s, Set<String> wordDict) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		List<String> dict= new LinkedList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		Set<String> dictSet= new HashSet<>(dict);
		WordBreak t=new WordBreak();
		System.out.println(t.wordBreak(s,dictSet));
	}

}
