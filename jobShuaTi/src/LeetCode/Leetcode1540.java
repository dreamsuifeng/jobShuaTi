package LeetCode;


/*
 * 自信心
 * 
 * 有 n 个学生按照序号从左到右依次排成一排进行考试。这 n 个学生的学习能力两两不同。对于第 i 个学生，如果有 j 个同学比他学习能力差且和他的座位之间最多隔一个位置，那么 i 同学考试时的自信心为 Aij。

但不幸的是，记录学生学习能力的表格丢失了。作为一个悲观的人A老师想请你帮助他计算出最坏情况下学生自信心总和为多少，即最小可能为多少。

输入
第一行一个数 T，表示数据组数

对于每一组数据：

第一行一个数 n

接下来 n 行，每行5个数分别表示 Ai0 ~ Ai4

对于30%的数据，1 ≤ n ≤ 10

对于50%的数据，1 ≤ n ≤ 100

对于100%的数据，1 ≤ T ≤ 10, 1 ≤ n ≤ 100000, 1 ≤ Aij ≤ 10000

输出
对于每组数据输出一个数，表示答案

样例输入
1
3
1 2 3 4 5
2 1 3 4 5
2 3 1 4 5
样例输出
3
 */
import java.util.Scanner;


public class Leetcode1540 {
	static int solve(int[][] data, int n){
		int[][] f=new int[n][120];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for (int i=0;i<T;++i){
			int n=in.nextInt();
			int[][] data=new int[n][5];
			for (int j=0;j<n;++j){
				for (int k=0;k<5;++k){
					data[j][k]=in.nextInt();
				}
			}
			
			
		}
	}

}
