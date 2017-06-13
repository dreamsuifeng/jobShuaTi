package otherAlgorithsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AliInterview {
	public static int solve(int m, int n) {
	      int[] res=new int[n+1];
	      res[1]=m;
	      res[2]=m*(m-1)%1000003;
	      res[3]=m*(m-1)*(m-2)%1000003;
	      if (n>3){
	    	  for (int i=4;i<=n;++i){
	    		  res[i]=(res[i-1]*(m-2)&1000003+res[i-2]*(m-1)%1000003)%1000003;
	    		  
	    	  }
	    	 
	      }
	      return (int) (Math.pow(m, n)-res[n]);
	  }
	public static boolean isTrue(String s){
		if (s.length()==0) return false;
		Stack<Character> stack=new Stack<>();
		for (int i=0;i<s.length();++i){
			if (s.charAt(i)=='('){
				stack.push('(');
			}else if (s.charAt(i)==')' && !stack.isEmpty()){
				stack.pop();
			}else if(s.charAt(i)==')' && stack.isEmpty()){
				return false;
			}
			else{
				continue;
			}
		}
		if (stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean solve(int m, int[] data, int cur, int tempSum) {
		if (tempSum %m== 0 && tempSum!=0) {
	        return true;
	    }
	    for (int i = cur; i < data.length; i++){
	        if (i > cur && data[i] == data[i-1]) continue;
	        tempSum+=data[i];
	        if(solve(m, data, i+1, tempSum)) return true;
	        else tempSum-=data[i];
	    }
		return false;
	  }
	
	
	 public List<List<Integer>> combinationSum2(int[] cand, int target) {
		    Arrays.sort(cand);
		    List<List<Integer>> res = new ArrayList<List<Integer>>();
		    List<Integer> path = new ArrayList<Integer>();
		    dfs_com(cand, 0, target, path, res);
		    return res;
		}
		void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
		    if (target == 0) {
		        res.add(new ArrayList(path));
		        return ;
		    }
		    if (target < 0) return;
		    for (int i = cur; i < cand.length; i++){
		        if (i > cur && cand[i] == cand[i-1]) continue;
		        path.add(path.size(), cand[i]);
		        dfs_com(cand, i+1, target - cand[i], path, res);
		        path.remove(path.size()-1);
		    }
		}
	public boolean solve(int[] data, int m){
		int n=data.length;
		boolean[][] dp=new boolean[n][m];
		int index=data[0]%m;
		if (index==0) return true;
		dp[0][index]=true;
		for (int i=1;i<n;++i){
			index=data[i]%m;
			dp[i][index]=true;
			for (int j=m-1;j>=0;--j){
				if(dp[i-1][j]){
					index=(j+data[i])%m;
					dp[i][index]=true;
				}
			}
			if (dp[i][0]) return true;
		}
		return false;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.print(Math.pow(3, 2));
		int m=7,n=7;
		int[] data= new int[]{1,1,1,1,1,1,1,1,9};
//		int res= (int) (Math.pow(m,n)-m*Math.pow(m-1,n-1));
		System.out.println(solve(m, data, 0, 0));
		System.out.println((int)(Math.pow(10, 6)+Math.pow(10, 9)));
		System.out.println(Integer.MAX_VALUE);
//		System.arraycopy(src, srcPos, dest, destPos, length);
	}
}
