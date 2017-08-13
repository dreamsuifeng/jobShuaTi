package NowcoderGAmeTest;

import java.util.HashSet;
import java.util.Scanner;

public class CollectionsSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String[] data=in.nextLine().split(" ");
		int w=Integer.parseInt(data[0]);
		int x=Integer.parseInt(data[1]);
		int y=Integer.parseInt(data[2]);
		int z=Integer.parseInt(data[3]);
		HashSet<Double> set=new HashSet<>();
		for (int p=w;p<=x;p++){
			for (int q=y;q<=z;q++){
				set.add((double)p/q);
			}
		}
		System.out.println(set.size());
	}

}
