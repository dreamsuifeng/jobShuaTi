package NowcoderGAmeTest;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
public class delDulStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] d=new int[n];
		for (int i=0;i<n;++i){
			d[i]=in.nextInt();
		}
		int[] index=new int[1000+2];
		for (int i=0;i<n;++i){
			index[d[i]]=i+1;
		}
		PriorityQueue<int[]> q=new PriorityQueue<>(16,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		
		for (int j=0;j<=1000;j++){
			if (index[j]!=0){
				int[] t=new int[2];
				t[0]=j;
				t[1]=index[j];
				q.add(t);
			}
		}
		while (!q.isEmpty()){
			System.out.print(q.poll()[0]);
			if (!q.isEmpty()){
				System.out.print(" ");
			}
		}
		System.out.println();
		
	}

}
