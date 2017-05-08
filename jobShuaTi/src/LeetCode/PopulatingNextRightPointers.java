package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
	public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
		 }
	 public void connect(TreeLinkNode root) {
		 	if (root==null){
		 		return;
		 	}
	        LinkedList<TreeLinkNode> Q1=new LinkedList<TreeLinkNode>();
	        LinkedList<TreeLinkNode> Q2=new LinkedList<TreeLinkNode>();
	        Q1.add(root);
	        while(Q1.isEmpty()!=false){
	        	while (Q1.isEmpty()!=false){
		        	TreeLinkNode tmp1=Q1.poll();
		        	if (tmp1.left!=null) Q2.add(tmp1.left);
		        	if (tmp1.right!=null) Q2.add(tmp1.right);
		        	if (Q1.isEmpty()!=false){
		        		tmp1.next=Q1.peek();
		        	}
		        }
		        while (Q2.isEmpty()!=false) {
					TreeLinkNode tmp2=Q2.poll();
					if (tmp2.left!=null) Q1.add(tmp2.left);
					if (tmp2.right!=null) Q1.add(tmp2.right);
					if (Q2.isEmpty()!=false) tmp2.next=Q2.peek();
				}
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> QTest=new LinkedList<Integer>();
		QTest.add(2);
		QTest.add(3);
		System.out.println(new ArrayList<Integer>().toString());
//		System.out.println(QTest.poll());
//		System.out.println(QTest.poll());
	}

}
