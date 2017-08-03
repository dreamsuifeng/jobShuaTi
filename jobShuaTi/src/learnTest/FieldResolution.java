package learnTest;

public class FieldResolution {
	interface Interface0{
		int A=0;
	}
	
	interface Interface1 extends Interface0{
//		int A=1;
	}
	interface Interface3{
		int A=2;
	}
	static class Parent implements Interface1{
		public static int A=3;
	}
	static class Sub extends Parent implements Interface3{
		public static int A=4;
	}
	static class parent{
		public static int A=1;
		static{
			A=2;
		}
	}
	static class Sub1 extends parent{
		public static int B=A;
	}
	
	public static void main(String[] args){
		System.out.println(Sub1.A);
	}
}
