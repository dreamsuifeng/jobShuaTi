package NowcoderGAmeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class uglyStr {
	public static int solve(char[] cs){
		int res=0;
		int id1=-1;
		int id2=-1;
		Map<Character, Character> map=new HashMap<>();
		map.put('A', 'B');
		map.put('B', 'A');
		for(int i=0;i<cs.length;++i){
			if (i>0 && cs[i]!='?' && cs[i]==cs[i-1]) res++;
			if (i>0 && cs[i]=='?' && cs[i-1]!='?') cs[i]=map.get(cs[i-1]);
			if (id1==-1 && cs[i]=='?') id1=i;
			if (id2==-1 && cs[i]!='?') id2=i;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		char[] cs=in.next().toCharArray();
		System.out.println(solve(cs));
	}

}
