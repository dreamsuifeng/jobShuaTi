package NowcoderGAmeTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huaweiTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		PriorityQueue<int[]> input=new PriorityQueue<>(16,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1]-o1[1];
			}

			
		});
		String[] inp=in.next().split(",");
		for (int i=0;i<inp.length;++i){
			System.out.println(inp[i]);
			int[] t=new int[2];
			t[0]=i;
			t[1]=Integer.parseInt(inp[i]);
			input.add(t);

		}
		while (!input.isEmpty()){
			System.out.print(input.poll()[0]);
			if (!input.isEmpty())
				System.out.print(",");
		}
	}

	
	
	
}
