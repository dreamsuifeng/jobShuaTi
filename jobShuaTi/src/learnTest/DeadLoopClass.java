package learnTest;

public class DeadLoopClass {
	static{
//		if (true){
			System.out.println(Thread.currentThread()+"init deadclass");
//			while(true){
//			}
//		}
	}
	public static void main(String[] args){
//		Runnable script=new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println(Thread.currentThread()+"start");
//				DeadLoopClass deadLoopClass=new DeadLoopClass();
//				System.out.println(Thread.currentThread()+"run over");
//			}
//		};
//		Thread thread1=new Thread(script);
//		Thread thread2=new Thread(script);
//		thread1.start();
//		thread2.start();
		System.out.println(1);
	}
}
