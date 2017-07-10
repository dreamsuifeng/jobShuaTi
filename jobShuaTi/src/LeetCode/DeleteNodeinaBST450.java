package LeetCode;

public class DeleteNodeinaBST450 {
	public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public void del(TreeNode root,int key, TreeNode parent){
		if (root.left==null && root.right==null){
			if (key<parent.val){
				parent.left=null;
			}else{
				parent.right=null;
			}
		}else if (root.right==null && root.left!=null){
			TreeNode pNode=root.left;
			TreeNode pParent=root;
			while(pNode.right!=null){
				pParent=pNode;
				pNode=pNode.right;
				
			}
			if (pParent!=root){
				pParent.right=pNode.left;
				root.val=pNode.val;
			}else{
				root.val=pNode.val;
				root.left=pNode.left;
			}
			
		}else{
			TreeNode pNode=root.right;
			TreeNode pParent=root;
			while(pNode.left!=null){
				pParent=pNode;
				pNode=pNode.left;
			}
			if (pParent!=root){
				pParent.left=pNode.right;
				root.val=pNode.val;
			}else{
				root.val=pNode.val;
				
				root.right=pNode.right;
			}
		}
	}
	public void delete(TreeNode root, int key,TreeNode parent){
		if (root==null) return;
		if (root.val==key){
			del(root,  key, parent);
			return;
		}else if (root.val<key){
			delete(root.right, key,root);
		}else {
			delete(root.left, key,root);
		}
	} 
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root.left==null && root.right==null && key==root.val) return null;
        delete(root, key, root);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
