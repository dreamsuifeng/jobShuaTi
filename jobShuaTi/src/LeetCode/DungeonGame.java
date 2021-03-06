package LeetCode;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
	    
	    int m = dungeon.length;
	    int n = dungeon[0].length;
	    
	    int[][] health = new int[m][n];

	    health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

	    for (int i = m - 2; i >= 0; i--) {            
	        health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
	    }

	    for (int j = n - 2; j >= 0; j--) {
	        health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
	    }

	    for (int i = m - 2; i >= 0; i--) {
	        for (int j = n - 2; j >= 0; j--) {
	            int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
	            int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
	            health[i][j] = Math.min(right, down);
	        }
	    }

	    return health[0][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t=new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
//		System.out.println(t[1][2]);
		System.out.println(calculateMinimumHP(t));

	}

}
