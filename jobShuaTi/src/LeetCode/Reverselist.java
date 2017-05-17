package LeetCode;

import LeetCode.ReorderList.ListNode;

public class Reverselist {
	public class ListNode {
		      int val;
		     ListNode next;
		      ListNode(int x) { val = x; }
		  }
		 
		
	public ListNode reverse(ListNode head){
		if (head==null || head.next==null) return head;
		ListNode p=head,q=head.next,tmp=null;
		p.next=null;
		while (q!=null){
		    tmp=q.next;
			q.next=p;
			p=q;
			q=tmp;
			
		}
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
