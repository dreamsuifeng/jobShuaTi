package LeetCode;

import java.util.HashMap;
import java.util.Random;

public class CopyListwithRandomPointer {
	class RandomListNode {
		      int label;
		      RandomListNode next, random;
		      RandomListNode(int x) { this.label = x; }
		  };
	public RandomListNode copyRandomList(RandomListNode head) {
       HashMap<Integer, RandomListNode> map=new HashMap<>();
       if (head==null){
    	   return null;
       }
       RandomListNode headNew =new RandomListNode(head.label), res=headNew, pnew=res, phead=head;
       map.put(head.label, res);
       phead=phead.next;
       while (phead!=null){
    	   headNew.next=new RandomListNode(phead.label);
    	   map.put(phead.label, headNew.next);
    	   phead=phead.next;
    	   headNew=headNew.next;
       }
       while (head!=null){
    	   if (head.random!=null){
    		   pnew.random=map.get(head.random.label);
    	   }
    	   head=head.next;
    	   pnew=pnew.next;
       }
       return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
