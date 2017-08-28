package hihoCoder;

import java.util.HashMap;
import java.util.Scanner;


public class TrieTree {
	static class Trie{
		private String[] array=null;
		public Trie(String[] inputs){
			this.array=inputs;
		}
		Node root=new Node();
		
		//node definition
		class Node{
			HashMap<Character, Node> child=new HashMap<Character,Node>();
			int preMount=0;
			boolean isWord;
//		public Node() {
//			// TODO Auto-generated constructor stub
//			
//		}
	}
		//create trieTree
		public void createTree(){
			for (int i=0;i<array.length;++i){
				String temp=array[i];
				Node pIndex=root;
				for (int j=0;j<temp.length();++j){
					if (pIndex.child.containsKey(temp.charAt(j))){
						pIndex.preMount+=1;
						pIndex=pIndex.child.get(temp.charAt(j));
					}else{
						pIndex.child.put(temp.charAt(j), new Node());
						pIndex.preMount+=1;
						pIndex=pIndex.child.get(temp.charAt(j));
						
					}
				}
				pIndex.preMount+=1;
				pIndex.isWord=true;
			}
		}
		public int[] printTree(String[] prefixs) {
			int[] result=new int[prefixs.length];
			for (int i=0;i<prefixs.length;++i){
				Node findIndex=root;
				String temp=prefixs[i];
				boolean findlabel=true;
				for (int j=0;j<temp.length();++j){
					if (findIndex.child.containsKey(temp.charAt(j))==false){
						findlabel=false;
						break;
					}
					findIndex=findIndex.child.get(temp.charAt(j));
				}
				if (findlabel){
					result[i]=findIndex.preMount;
				}else{
					result[i]=0;
				}
			}
			return result;
		}
	}
	public static void main(String[] args){
		@SuppressWarnings("resource")
		boolean t=new StringBuilder().append("abc").equals("abc");
		System.out.println(t);
		Scanner in=new Scanner(System.in);
		while (in.hasNext()) {
			int Words=in.nextInt();
			String[] inputs=new String[Words];
			for (int i=0;i<Words;++i){
				inputs[i]=in.next();
			}
//			System.out.println(inputs[1]);
			Trie Tree=new Trie(inputs);
			Tree.createTree();
			int prefixs=in.nextInt();
			String[] outputs=new String[prefixs];
			for (int j=0;j<prefixs;++j){
				outputs[j]=in.next();
			}
			int[] prints=Tree.printTree(outputs);
			for (int m=0;m<prints.length;++m){
				System.out.println(prints[m]);
			}
			
		}
	}
}
