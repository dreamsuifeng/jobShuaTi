package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

import LeetCode.PrefixTree.Node;

public class AddandSearchWord {
	
	public class WordDictionary {
		private class Trie{
			class Node{
				HashMap<Character, Node> child=new HashMap<Character,Node>();
				int preMount=0;
				boolean isWord;
			}
			private Node root;
		    public Trie() {
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
		    public boolean search(String word, Node head) {
		        Node pIndex=head;
		        for (int i=0;i<word.length();++i){
		        	if (word.charAt(i)!='.'){
			        	if (pIndex.child.containsKey(word.charAt(i))){
							pIndex=pIndex.child.get(word.charAt(i));
							
						}else{
							return false;
							}
		        	}else{
		        		Iterator<Character> iterator=pIndex.child.keySet().iterator();
		        		while (iterator.hasNext()){
		        			if (search(word.substring(i+1),pIndex.child.get(iterator.next()))) return true;
		        		}
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
	    /** Initialize your data structure here. */
		
		private Trie tree;
	    public WordDictionary() {
	        tree=new Trie();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        tree.insert(word);
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return tree.search(word,tree.root);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
