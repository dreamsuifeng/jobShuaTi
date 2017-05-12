package LeetCode;

import javax.net.ssl.SSLContext;

public class SortList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode merge(ListNode root1, ListNode root2){
		if (root1==null || root2==null){
			return root1==null ? root2:root1;
		}
        ListNode res=new ListNode(0);
        ListNode head=res;
        while (root1!=null && root2!=null){
        	if (root1.val<root2.val){
        		res.next=root1;
        		res=res.next;
        		root1=root1.next;
        	}else{
        		res.next=root2;
        		res=res.next;
        		root2=root2.next;
        	}
        }
        while (root1!=null){
        	res.next=root1;
        	res=res.next;
        	root1=root1.next;
        }
        while (root2!=null){
        	res.next=root2;
        	res=res.next;
        	root2=root2.next;
        }
        return head.next;
    }
	 public ListNode getMiddle(ListNode head) {
	        if (head == null) {
	            return head;
	        }
	        //快慢指针
	        ListNode slow, fast;
	        slow = fast = head;
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
        //得到链表中间的数
        ListNode middle = getMiddle(head);
        ListNode sHalf = middle.next;
        //拆分链表
        middle.next = null;
        //递归调用
        return merge(sortList(head), sortList(sHalf));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
