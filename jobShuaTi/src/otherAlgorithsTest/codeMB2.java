package otherAlgorithsTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class codeMB2 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int q=in.nextInt();
		int[] source=new int[m];
		int[] target=new int[m];
		int[] val=new int[m];
		for (int i=0;i<m;++i){
			source[i]=in.nextInt();
			target[i]=in.nextInt();
			val[i]=in.nextInt();
		}
		int[][] needs=new int[q][4];
		for(int i=0;i<q;++i){
			needs[i][0]=in.nextInt();
			needs[i][1]=in.nextInt();
			needs[i][2]=in.nextInt();
			needs[i][3]=in.nextInt();
		}
		Arrays.sort(needs,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[2]!=o2[2]) return o1[2]-o2[2];
				else return o1[3]-o2[3];
			}
		});
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for (int i=0;i<q;++i){
			
		}
	}
}
