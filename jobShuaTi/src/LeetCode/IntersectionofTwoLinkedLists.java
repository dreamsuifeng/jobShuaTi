package LeetCode;

public class IntersectionofTwoLinkedLists {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA;
        int lenA=0;
        int lenB=0;
        while (p!=null){
        	p=p.next;
        	lenA++;
        }
        p=headB;
        while (p!=null){
        	p=p.next;
        	lenB++;
        }
        int dis=Math.abs(lenA-lenB);
        p= lenA>lenB ? headA:headB;
        ListNode q = lenA>lenB ? headB:headA;
        for (int i=0;i<dis;++i){
        	p=p.next;
        }
        while (p!=null && q!=null){
        	if (p==q){
        		return p;
        	}
        	p=p.next;
        	q=q.next;
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
