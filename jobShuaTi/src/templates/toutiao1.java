package templates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class toutiao1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		List<Integer> d=new ArrayList<>();
		int num1=3-(n%3);
		if (num1==3) num1=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for (int i=0;i<n;++i){
			int tmp=in.nextInt();
			if (min>tmp) min=tmp;
			if (max<tmp) max=tmp;
			d.add(tmp);
		}
		int num2=(max-min)/10-n;
		if (num1>num2) System.out.println(num1);
		else System.out.println(num2);
	}

}
