package learnTest;



class ConstClass{
	static{
		System.out.println("Const init!");
	}
	public static final String HELLO="hello";
}
class SuperClass{
	static{
		System.out.println("Superclass init!");
	}
	public static int value=123;
}
class SubClass extends SuperClass{
	static{
		System.out.println("subclass init!");
	}
}
public class NotInitialization {
	public static final String value=ConstClass.HELLO; 
	public static void main(String[] args){
		System.out.println(NotInitialization.value);
	}
}
