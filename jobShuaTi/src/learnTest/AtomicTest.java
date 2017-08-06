package learnTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	public static AtomicInteger race=new AtomicInteger(0);
	public static void increase(){
		race.incrementAndGet();
	}
	
	private static final int THREADS=20;
	
	public static void main(String[] args) throws Exception{
		Thread[] threads=new Thread[THREADS];
		for (int i=0;i<THREADS;i++){
			threads[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i=0;i<10000;++i){
						increase();
					}
				}
			});
			threads[i].start();
		}
		while (Thread.activeCount()>1){
			Thread.yield();
		}
		System.out.println(race);
		
	}
}
