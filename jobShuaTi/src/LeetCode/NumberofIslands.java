package LeetCode;

public class NumberofIslands {
	 public static void erase(char[][] A, int i, int j) {
         A[i][j] = '0';
         while (i - 1 >= 0 && A[i - 1][j] == '1') {
             erase(A, i - 1, j);
         }
         while (i + 1 < A.length && A[i + 1][j] == '1') {
             erase(A, i + 1, j);
         }
         while (j - 1 >= 0 && A[i][j - 1] == '1') {
             erase(A, i, j - 1);
         }
         while (j + 1 < A[0].length && A[i][j + 1] == '1') {
             erase(A, i, j + 1);
         }
         
     }
	public int numIslands(char[][] grid) {
		int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    erase(grid, i, j);
                }
            }
       }
       return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
