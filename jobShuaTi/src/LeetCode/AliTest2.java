package LeetCode;

import java.util.Scanner;

public class AliTest2 {
	
	static int[][] Revisied(int[][] jiguangs, int M, int N){
		int[][] Maze=new int[M][N];
		for (int i=0;i<jiguangs.length;++i){
			double temp=(double)(jiguangs[i][3]-jiguangs[i][1])/(double)(jiguangs[i][2]-jiguangs[i][0]);
			for (int j=jiguangs[i][0];j<=jiguangs[i][2];++j){
				for (int k=jiguangs[i][1];k<=jiguangs[i][3];++k){
					double temp1=(double)(k-jiguangs[i][1])/(double)(j-jiguangs[i][0]);
					if (temp1==temp){
						Maze[j][k]=1;
					}else{
						Maze[j][k]=0;
					}
				}
			}
		}
		return Maze;
	}
	void check(int[][] Mazes, int i, int j, int M, int N) {
        if (i == M- 1 && j == N - 1) {
            return;
        }
 
        //向右走
        if (canMove(Mazes,i, j, i, j + 1,M,N)) {
            Mazes[i][j] = 5;
            check(Mazes,i, j + 1, M, N);
            Mazes[i][j] = 0;
        }
        //向左走
        if (canMove(Mazes, i, j, i, j - 1, M, N)) {
            Mazes[i][j] = 5;
            check(Mazes, i, j - 1, M, N);
            Mazes[i][j] = 0;
        }
        //向下走
        if (canMove(Mazes, i, j, i + 1, j, M, N)) {
            Mazes[i][j] = 5;
            check(Mazes, i + 1, j, M, N);
            Mazes[i][j] = 0;
        }
        //向上走
        if (canMove(Mazes, i, j, i - 1, j, M, N)) {
            Mazes[i][j] = 5;
            check(Mazes, i - 1, j, M, N);
            Mazes[i][j] = 0;
        }
    }
 
   boolean canMove(int[][] Mazes, int i, int j, int targetI, int targetJ, int M, int N) {
        if (targetI < 0 || targetJ < 0 || targetI >= M || targetJ >= N) {

            return false;
        }
        if (Mazes[targetI][targetJ] == 1) {

            return false;
        }
        if (Mazes[targetI][targetJ] == 5) {
            return false;
        }
 
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int M=in.nextInt();
		int N=in.nextInt();
		int jiguangCount=in.nextInt();
		int[][] jiguangs=new int[jiguangCount][4];
		for (int i=0;i<jiguangCount;++i){
			for (int j=0;j<4;++j){
			jiguangs[i][j]=in.nextInt();
		}
			
		}
		
	}

}
