package LeetCode;

import java.util.LinkedList;
import java.util.Queue;





public class Contest46_2 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
//	int leftMost=1;
//	int rightMost=1;
//	private void  right(TreeNode root){
//		if (root==null) return;
//		if (root.right!=null) {
//			rightMost*=2;
//			right(root.right);
//		}else if (root.left!=null){
//			rightMost=rightMost*2-1;
//			right(root.left);
//		}
//	}
//	private void  left(TreeNode root){
//		if (root==null) return;
//		if (root.left!=null) {
//			left(root.left);
//		}else if (root.right!=null){
//			leftMost=leftMost*2;
//			left(root.right);
//		}
//	}
	
	class seqNode{
		TreeNode pNode;
		int seq;
	}
	public int widthOfBinaryTree(TreeNode root) {
		int ans=Integer.MIN_VALUE;
        LinkedList<seqNode> fq=new LinkedList<>();
        LinkedList<seqNode> sq=new LinkedList<>();
        seqNode r=new seqNode();
        r.pNode=root;
        r.seq=1;
        fq.add(r);
        while (!fq.isEmpty()){
        	int anst=0;
        	seqNode first=fq.peekFirst();
        	seqNode eNode=fq.peekLast();
        	int start=first.seq;
        	int end=eNode.seq;
        	ans=Math.max(ans, end-start+1);
            System.out.println(ans);
        	while(!fq.isEmpty()){
        		seqNode t=fq.poll();
        		if (t.pNode.left!=null){
        			seqNode tmp=new seqNode();
        			tmp.pNode=t.pNode.left;
        			tmp.seq=t.seq*2-1;
        			sq.add(tmp);
        		}
        		if (t.pNode.right!=null){
        			seqNode tmp=new seqNode();
        			tmp.pNode=t.pNode.right;
        			tmp.seq=t.seq*2;
        			sq.add(tmp);
        		}
    
        	}
        	fq.addAll(sq);
        	sq.clear();
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
