package LeetCode;

import java.util.HashMap;

//import hihoCoder.TrieTree.Trie.Node;

public class PrefixTree {
	 /** Initialize your data structure here. */
	class Node{
		HashMap<Character, Node> child=new HashMap<Character,Node>();
		int preMount=0;
		boolean isWord;
	}
	private Node root;
    public PrefixTree() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node pIndex=root;
        for (int i=0;i<word.length();++i){
        	if (pIndex.child.containsKey(word.charAt(i))){
				pIndex.preMount+=1;
				pIndex=pIndex.child.get(word.charAt(i));
			}else{
				pIndex.child.put(word.charAt(i), new Node());
				pIndex.preMount+=1;
				pIndex=pIndex.child.get(word.charAt(i));
				
			}
		}
		pIndex.preMount+=1;
		pIndex.isWord=true;
	}
        
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node pIndex=root;
        for (int i=0;i<word.length();++i){
        	if (pIndex.child.containsKey(word.charAt(i))){
				pIndex=pIndex.child.get(word.charAt(i));
				
			}else{
				return false;
				
				
			}
       }
        if (pIndex.isWord){
        	return true;
        }else{
        	return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Node pIndex=root;
        for (int i=0;i<prefix.length();++i){
        	if (pIndex.child.containsKey(prefix.charAt(i))){
				pIndex=pIndex.child.get(prefix.charAt(i));
				
			}else{
				return false;
				
				
			}
       }
        if (pIndex.preMount>0){
        	return true;
        }else{
        	return false;
        }
    }
}
