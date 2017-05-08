package LeetCode;

import java.util.Scanner;

public class Didi2 {
	public static int getCount(int[][] A) {
          int result = 0;
          for (int i = 0; i < A.length; i++) {
              for (int j = 0; j < A[0].length; j++) {
                  if (A[i][j] == 1) {
                      result++;
                     erase(A, i, j);
                  }
              }
         }
         return result;
     }
		 
     public static void erase(int[][] A, int i, int j) {
         A[i][j] = 0;
         while (i - 1 >= 0 && A[i - 1][j] == 1) {
             erase(A, i - 1, j);
         }
         while (i + 1 < A.length && A[i + 1][j] == 1) {
             erase(A, i + 1, j);
         }
         while (j - 1 >= 0 && A[i][j - 1] == 1) {
             erase(A, i, j - 1);
         }
         while (j + 1 < A[0].length && A[i][j + 1] == 1) {
             erase(A, i, j + 1);
         }
         
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {// 注意while处理多个case
			int m=in.nextInt();
			int n=in.nextInt();
//			System.out.println(m+","+n);
			int[][] data=new int[m][n];
			for (int i=0;i<m;++i){
				String temp=in.next();
				for (int j=0;j<temp.length();++j){
					data[i][j]=Integer.parseInt(""+(temp.charAt(j)));
//					System.out.println(data[i][j]);
				}
			}
			
			System.out.println(Didi2.getCount(data));

		}

	}
	}

