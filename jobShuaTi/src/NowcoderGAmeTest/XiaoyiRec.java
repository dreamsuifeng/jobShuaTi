package NowcoderGAmeTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XiaoyiRec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		Set<String> set=new HashSet<>();
		for(int i=0;i<n;++i){
			set.add(in.next());
		}
		int an=0;
		for (int i=0;i<m;++i){
			String s=in.next();
			if (set.contains(s)){
				an+=Math.pow(s.length(), 2);
			}
		}
		System.out.println(an);
		
		
	}

}
