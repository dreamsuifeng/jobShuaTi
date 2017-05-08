package LeetCode;

public class SurroundedRegions {
	private char[][] data=null;
	public void erase(char[][] A, int i, int j, char rep) {
		A[i][j] = rep;
		if (i - 1 >= 0 && A[i - 1][j] == 'O') {
			erase(A, i - 1, j, rep);
		}
		if (i + 1 < A.length-1 && A[i + 1][j] == 'O') {
			erase(A, i + 1, j, rep);
		}
		if (j - 1 >= 0 && A[i][j - 1] == 'O') {
			erase(A, i, j - 1, rep);
		}
		if (j + 1 < A[0].length-1 && A[i][j + 1] == 'O') {
			erase(A, i, j + 1, rep);
		}

	}
	public void setEageReach(char[][] A){
		for (int i=0;i<A[0].length;++i){
			if (A[0][i]=='O'){
				erase(A, 0, i, 'C');
			}
			if (A[A.length-1][i]=='O'){
				erase(A, A.length-1, i, 'C');
			}
		}
		for (int j=0;j<A.length;++j){
			if (A[j][0]=='O'){
				erase(A, j, 0, 'C');
			}
			if (A[j][A[0].length-1]=='O'){
				erase(A, j, A[0].length-1,'C');
			}
		}
	}
	public void solve(char[][] board) {
	    if (board.length==0 || board[0].length==0) return;
		setEageReach(board);
        for (int i=0;i<board.length;++i){
        	for (int j=0;j<board[0].length;++j){
        		if (board[i][j]=='C'){
        			board[i][j]='O';
        		}else if (board[i][j]=='O'){
        		    board[i][j]='X';
        		}
        	}
        }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
