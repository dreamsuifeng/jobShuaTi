package LeetCode;


public class FriendCycle547 {
	
	 static int[] father;
	    public int findCircleNum(int[][] M) {
	        //corner case
	        if(M.length == 0 || M[0].length == 0) return 0;

	        int m = M.length;
	        father = new int[m];
	        for(int i = 0; i < m; i++){
	            father[i] = i;
	        }
	        int counter = m;//initial counter as m

	        for(int i = 0; i < m ; i++){
	            for(int j = i + 1; j < m; j++){
	                if(M[i][j] == 1){
	                    //Only need to union when they are in different groups
	                    int father1 = find(i);
	                    int father2 = find(j);
	                    if(father1 == father2) continue;
	                    
	                    union(i, j);
	                    counter--;
	                }
	            }
	        }

	        return counter;
	    }

	    private int find(int root){
	        if(father[root] == root) return father[root];

	        father[root] = find(father[root]);
	        return father[root];
	    }

	    private void union(int root1, int root2){
	        int father1 = find(root1);
	        int father2 = find(root2);

	        if(father1 != father2){
	            father[father1] = father2;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
