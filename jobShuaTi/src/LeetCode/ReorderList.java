package LeetCode;

public class ReorderList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
//	 public void reorderList(ListNode head) {
//	        if (head==null || head.next==null || head.next.next==null){
//	            return;
//	        }
//	        ListNode p=head, q=head, l=head;
//	        
//	        while (p!=null && q.next!=null){
//	            q=l.next;
//	            while(q.next!=null){
//	                q=q.next;
//	                l=l.next;
//	            }
//	            if (p.next==q) return;
//	            q.next=p.next;
//	            p.next=q;
//	            l.next=null;
//	            p=q.next;
//	            q=p;
//	            l=q;
//	        }
//	    }
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
	public void reorderList(ListNode head){
		if (head==null ||head.next==null || head.next.next==null ) return;
		ListNode p=head, q=head.next,head2=q;
		while (q!=null && q.next!=null){
			p.next=q.next;
			p=q;
			q=q.next;
		}
		p.next=null;
		ListNode t=head;
		while (t!=null){
		    System.out.print(t.val+",");
		    t=t.next;
		}
		System.out.println();
		t=head2;
		while (t!=null){
		    System.out.print(t.val+",");
		    t=t.next;
		}
		System.out.println();
		head2=reverse(head2);
		t=head2;
		while (t!=null){
		    System.out.print(t.val+",");
		    t=t.next;
		}
		while (head!=null && head2!=null){
			p=head.next;
			q=head2.next;
			head.next=head2;
			head2.next=p;
			head=p;
			head2=q;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
