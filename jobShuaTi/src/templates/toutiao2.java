package templates;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;


class Trie{
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
	}
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
	public long search(String pre,String m){
		char[] pres=pre.toCharArray();
		char[] ms=m.toCharArray();
		long ans=0;
		Node pindex=root;
		int i=0;
		for (;i<pres.length;++i){
			if (pindex==null) break;
			if (pres[i]=='0' && ms[i]=='0'){
				if (pindex.child.get('1')!=null){
					ans+=pindex.child.get('1').preMount;
				}
				pindex=pindex.child.get('0');
			}else if (pres[i]=='0' && ms[i]=='1'){
				 pindex=pindex.child.get('1');
			}else if (pres[i]=='1' && ms[i]=='0'){
				if (pindex.child.get('0')!=null){
					ans+=pindex.child.get('0').preMount;
				}
				pindex=pindex.child.get('1');
			}else {
				pindex=pindex.child.get('0');
			}
			
		}
		return ans;
	}
}
public class toutiao2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		String[] inputs=new String[n];
		for (int i=0;i<n;++i){
			int t=in.nextInt();
			String tmp=Integer.toBinaryString(t);
			
			int len=tmp.length();
			for (int j=0;j<32-len;++j){
				tmp="0"+tmp;
			}
		
			inputs[i]=tmp;
			
		}
		Trie tree=new Trie(inputs);
		tree.createTree();
		String mString=Integer.toBinaryString(m);
		int len=mString.length();
		for (int j=0;j<32-len;++j){
			mString="0"+mString;
		}
		long ans=0;
		for (int i=0;i<n;++i){
			ans+=tree.search(inputs[i], mString);
		}
	
		System.out.println(ans/2);
	}

}
