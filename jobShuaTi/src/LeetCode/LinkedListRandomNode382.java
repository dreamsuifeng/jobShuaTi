package LeetCode;

import java.util.List;
import java.util.Random;

class LinkedListRandomNode382 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	private ListNode r;
	private int size;
	public LinkedListRandomNode382(ListNode head){
		r=head;
		int len=0;
		while(r!=null){
			len++;
		}
		size=len;
	}
	public int getRandom(){
		Random random=new Random();
		int idx=random.nextInt(size);
		ListNode p=r;
		for (int i=1;i<=idx;++i){
			p=p.next;
		}
		return p.val;
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
