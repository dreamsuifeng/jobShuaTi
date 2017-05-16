package LeetCode;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		if (dungeon.length==0) return 0;
        int m=dungeon.length, n=dungeon[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=dungeon[0][0]>=0 ? 1: -dungeon[0][0]+1;
        int[][] xueliang=new int[m][n];
        xueliang[0][0]= dungeon[0][0]>=0 ? dungeon[0][0]+1:1;
        
        for (int i=1;i<n;++i){
        	if (dungeon[0][i]>=0){
        		dp[0][i]=dp[0][i-1];
        		xueliang[0][i]=xueliang[0][i-1]+dungeon[0][i];
        	}else{
        		int t=dp[0][i-1]-dungeon[0][i]-xueliang[0][i-1]+1;
        		dp[0][i]=t>dp[0][i-1] ? t:dp[0][i-1];
        		xueliang[0][i]=t>dp[0][i-1] ? 1:xueliang[0][i-1]+dungeon[0][i];
        	}
        }
        for(int j=1;j<m;++j){
        	if (dungeon[j][0]>=0){
        		dp[j][0]=dp[j-1][0];
        		xueliang[j][0]=xueliang[j-1][0]+dungeon[j][0];
        	}else{
        		int t=dp[j-1][0]-dungeon[j][0]-xueliang[j-1][0]+1;
        		dp[j][0]= t>dp[j-1][0] ? t:dp[j-1][0];
        		xueliang[j][0]= t>dp[j-1][0] ? 1:xueliang[j-1][0]+dungeon[j][0];
        	}
        }
        
        for (int i=1;i<m;++i){
        	for (int j=1;j<n;++j){
        		if (dungeon[i][j]>=0){
        			dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1]);
        			if (dp[i-1][j]==dp[i][j-1]){
        				xueliang[i][j]=Math.max(xueliang[i-1][j], xueliang[i][j-1])+dungeon[i][j];
        			}
        			else xueliang[i][j]= dp[i-1][j]<dp[i][j-1] ? xueliang[i-1][j]+dungeon[i][j]:xueliang[i][j-1]+dungeon[i][j];
        		}else{
        			int left=dp[i][j-1]-dungeon[i][j]-xueliang[i][j-1]+1;
        			
        			int up=dp[i-1][j]-dungeon[i][j]-xueliang[i-1][j]+1;
        			left=left>dp[i][j-1] ? left:dp[i][j-1];
        			int xueliangleft=left>dp[i][j-1] ? 1:xueliang[i][j-1]+dungeon[i][j];
        			up=up>dp[i-1][j] ? up:dp[i-1][j];
        			int xueliangup=up>dp[i-1][j] ? 1:xueliang[i-1][j]+dungeon[i][j];
        			if (left==up){
        				xueliang[i][j]=Math.max(xueliangleft, xueliangup);
        			}else{
        				xueliang[i][j]= left<up ? xueliangleft:xueliangup;
        			}
        			dp[i][j]=Math.min(left, up);
        		}
        	}
        }
        for (int[] is : dp) {
			for (int i : is) {
				System.out.print(i+",");
			
			}
			System.out.println();
		}
        System.out.println();
        for (int[] is : xueliang) {
			for (int i : is) {
				System.out.print(i+",");
			
			}
			System.out.println();
		}
        return dp[m-1][n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t=new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
//		System.out.println(t[1][2]);
		System.out.println(calculateMinimumHP(t));

	}

}
