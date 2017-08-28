package templates;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestPrivate {
	class A{
		private int a;
		public int get(){
			return a;
		}
	}
	
	class B{
		private int b;
		A aa=new A();
		int c=aa.a;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
//		InputStreamReader in=new InputStreamReader(System.in);
		
		in.useDelimiter("/");
		List<Character> list=new LinkedList<>();
			list.add((char)in.nextByte());
			
		System.out.println(list);
	}

}
