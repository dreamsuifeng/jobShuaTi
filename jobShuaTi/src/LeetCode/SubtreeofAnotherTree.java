package LeetCode;


public class SubtreeofAnotherTree {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private StringBuffer preStringT=new StringBuffer();
	private StringBuffer preStringS=new StringBuffer();
	private StringBuffer inStringS=new StringBuffer();
	private StringBuffer inStringT=new StringBuffer();
	public void preOrderS(TreeNode s){
		if (s!=null){
			preStringT.append(s.val);
		}
		if (s.left!=null) preOrderS(s.left);
		if (s.right!=null) preOrderS(s.right);
	}
	public void preOrderT(TreeNode s){
		if (s!=null){
			preStringS.append(s.val);
		}
		if (s.left!=null) preOrderT(s.left);
		if (s.right!=null) preOrderT(s.right);
	}
	public void InOrderS(TreeNode s){
		
		if (s.left!=null) InOrderS(s.left);
		if (s!=null){
			inStringS.append(s.val);
		}
		if (s.right!=null) InOrderS(s.right);
	}
	public void InOrderT(TreeNode s){
			
			if (s.left!=null) InOrderS(s.left);
			if (s!=null){
				inStringT.append(s.val);
			}
			if (s.right!=null) InOrderT(s.right);
		}
	
	public boolean isSubTree(TreeNode s, TreeNode t){
		if (s==null && t==null){
			return true;
		}
		if (s==null && t!=null){
			return false;
		}
		if (s!=null && t==null){
			return false;
		}
		if (s.val==t.val){
			return isSubTree(s.left, t.left) || isSubTree(s.right, t.right);
		}
		else {
			return isSubTree(s.left, t) || isSubTree(s.right, t);
		}
	}
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        preOrderS(s);
	        preOrderT(t);
	        InOrderS(s);
	        InOrderT(t);
	        if(preStringS.toString().contains(preStringT.toString()) && inStringS.toString().contains(inStringT.toString())){
	        	return true;
	        }
	        else{
	        	return false;
	        }
	    }
	 public static void main(String[] args){
		 StringBuffer tTest=new StringBuffer();
		 tTest.append("abc");
		 tTest.append(5);
		 System.out.println(tTest.toString());
		 System.out.println(tTest.toString().contains("acd"));
	 }
}
