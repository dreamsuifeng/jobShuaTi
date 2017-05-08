package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder {
	public int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
        // wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<String>(wordList);
        return ladderLength1(beginWord, endWord, wordSet);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input={"hot","dot","dog","lot","log","cog"};
		ArrayList<String> wordList=new ArrayList<>();
		for (int i=0;i<input.length;++i){
			wordList.add(input[i]);
		}
		String beginWord="hit";
		String endWord="cog";
		WordLadder test=new WordLadder();
		System.out.println(test.ladderLength(beginWord, endWord, wordList));
	}

}
