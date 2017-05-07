package LeetCode;

class ConvertSortedListtoBinarySearchTree {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public class TreeNode {
			      int val;
			      TreeNode left;
			      TreeNode right;
			      TreeNode(int x) { val = x; }
			 }
	public class Solution {
			public ListNode getnNodeOfList(ListNode head, int n){
				ListNode p=head;
				for(int i=0;i<n;++i){
					p=p.next;
				}  
				return p;
			}
			public TreeNode createTree(ListNode head, int start, int end){
				if (start>end){
					return null;
				}
				int midPos=(start+end)/2;
				ListNode mid=getnNodeOfList(head, midPos-start);
				TreeNode root=new TreeNode(mid.val);
				if (start == end){
					return root;
				}
				root.left=createTree(head, start, midPos-1);
				root.right=createTree(mid.next, midPos+1, end);
				return root;
			}
		public TreeNode sortedListToBST(ListNode head) {
		  	int len=0;
//		  	ArrayList
		  	ListNode p=head;
		  	while(p!=null){
		  		len++;
		  		p=p.next;
		  	}
		      return createTree(head, 0, len-1);
		  }
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
