package hihoCoder;

import java.util.*;



public class hiho23_2 {
	static class node{
		String name;
		HashMap<String, node> childcp;
		boolean isfile;
		public node(){
			
			childcp=new HashMap<>();
			isfile=false;
		}
	}
	public static void insert(String[] lines,node root,int j){
		if (j>=lines.length) return;
		if (!root.childcp.containsKey(lines[j])){
			node t=new node();
			t.name=lines[j];
			if (j==lines.length-1){
				t.isfile=true;
			}
			
			root.childcp.put(lines[j], t);
		}
		insert(lines, root.childcp.get(lines[j]),j+1);
	}
		
	public static void printfile(node root,String cur,String[] files){
		String anString="/";
		node r=root;
		node t;
		for (int i=0;i<files.length;++i){
			t=r.childcp.get(files[i]);
			if (t!=null && (t.childcp.size()>1 || i==files.length-2)){
				anString+=t.name+"/";
			}else if (t!=null && t.childcp.size()==1){
				anString+=t.name+"-";
			}
			r=t;
		}
		anString+=r.name;
		System.out.println(anString);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		node root=new node();
		root.name="noone";
		int N=in.nextInt();
		in.nextLine();
		String[][] inputs=new String[N][];
		for (int i=0;i<N;++i){
			inputs[i]=in.nextLine().substring(1).split("/");
			insert(inputs[i], root, 0);
		}
		for (int i=0;i<N;++i){
			printfile(root, "/", inputs[i]);
		}
		
	}

}
