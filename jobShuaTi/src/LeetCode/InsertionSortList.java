package LeetCode;

public class InsertionSortList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null){
        	return head;
        }
        ListNode p,q=head.next;
        head.next=null;
        while(q!=null){
        	ListNode pPre=null;
        	p=head;
        	while (p.val<q.val){
        		pPre=p;
        		p=p.next;
        	}
        	ListNode qNext=q.next;
        	q.next=p;
        	if (pPre!=null) pPre.next=q;
        	if (pPre==null) head=q;
        	q=qNext;
        }
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
