package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordLadderII {
	private List<String> tempList=new ArrayList<String>();
	private List<List<String>>  ladders=new ArrayList<List<String>>();
	private HashSet<String> usedWord=new HashSet<String>();
	private int manyDis(String one, String two){
		if (one.length()!=two.length()) System.exit(0);;
		int dis=0;
		for (int i=0;i<one.length();++i){
			if (one.charAt(i)!=two.charAt(i)) dis++;
		}
		return dis;
	}
	public void findLadder(String beginWord, String endWord, HashMap<String,Integer> wordMap,List<String> wordListSorted,int step){
		tempList.add(beginWord);
		usedWord.add(beginWord);
		if (beginWord.equals(endWord)) {
			ladders.add(new ArrayList<String>(tempList));
			usedWord.remove(tempList.get(tempList.size()-1));
			tempList.remove(tempList.size()-1);
			return;
		}
//		System.out.println(tempList.toString());
		if (step==wordListSorted.size()) return;
		int preMinDis=-1;
		for (int i=0;i<wordListSorted.size();++i){
			String temp=wordListSorted.get(i);
			if (usedWord.contains(temp)==false && manyDis(temp, beginWord)==1){
				int tmpDis=manyDis(temp, endWord);
				if (preMinDis==-1) preMinDis=tmpDis;
				if (tmpDis==preMinDis) {
					findLadder(temp, endWord, wordMap, wordListSorted,step+1);
				}else{
//					usedWord.remove(tempList.get(tempList.size()-1));
					
					break;
				}
			}
		}
		usedWord.remove(tempList.get(tempList.size()-1));
		tempList.remove(tempList.size()-1);
		
	}
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> wordMapDis=new HashMap<String, Integer>();
        for (String str: wordList){
        	wordMapDis.put(str, manyDis(str, endWord));
        }

        List<Entry<String,Integer>> tlist =
        		new ArrayList<Entry<String,Integer>>(wordMapDis.entrySet());

        Collections.sort(tlist, new Comparator<Map.Entry<String, Integer>>() {
        	public int compare(Map.Entry<String, Integer> o1,
        			Map.Entry<String, Integer> o2) {
        		return (o1.getValue() - o2.getValue());}});
        List<String> wordListSorted=new ArrayList<String>();
        for (Map.Entry<String, Integer> entry: tlist){
        	wordListSorted.add(entry.getKey());
        }
        findLadder(beginWord, endWord, wordMapDis, wordListSorted,0);
        return ladders;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII test=new WordLadderII();
		String[] input={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm",
				 "ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe",
				 "ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb",
				 "if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi",
				 "qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi",
				 "am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//		"red"
//		"tax"
//		["ted","tex","red","tax","tad","den","rex","pee"]
//		"qa"
//		"sq"
//		["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm",
//		 "ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe",
//		 "ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb",
//		 "if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi",
//		 "qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi",
//		 "am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
		ArrayList<String> wordList=new ArrayList<>();
		for (int i=0;i<input.length;++i){
			wordList.add(input[i]);
		}
		String beginWord="qa";
		String endWord="sq";
		List<List<String>> result=test.findLadders(beginWord, endWord, wordList);
		System.out.println(result.toString());
	}
}


