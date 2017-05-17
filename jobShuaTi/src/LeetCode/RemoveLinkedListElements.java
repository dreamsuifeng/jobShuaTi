package LeetCode;

public class RemoveLinkedListElements {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        ListNode p=head,q=head;
        while(p.val==val){
        	p=p.next;
        	q.next=null;
        	q=p;
        }
        q=p.next;
        head=p;
        while(q!=null){
        	if (q.val==val){
        		p.next=q.next;
        		q=p.next;
        	}else{
        		p=q;
        		q=p.next;
        	}
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
