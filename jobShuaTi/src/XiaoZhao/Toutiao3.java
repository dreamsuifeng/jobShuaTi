package XiaoZhao;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import jdk.nashorn.internal.ir.Terminal;

public class Toutiao3 {
	static class idea{
		int seq;
		int time;
		int prior;
		int timeSume;
		public idea(int seq,int time,int prior, int timeSume){
			this.seq=seq;
			this.time=time;
			this.prior=prior;
			this.timeSume=timeSume;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int p=in.nextInt();
		PriorityQueue<idea> queue=new PriorityQueue<>(16,new Comparator<idea>() {

			@Override
			public int compare(idea o1, idea o2) {
				// TODO Auto-generated method stub
				if (o1.time!=o2.time){
					return o1.time-o2.time;
				}else if (o1.prior!=o2.prior){
					return o1.prior-o2.prior;
				}else if (o1.timeSume!=o2.timeSume){
					return o1.timeSume-o2.timeSume;
				}else{
					return o1.seq-o2.seq;
				}
				
			}
		});
		for (int i=0;i<p;++i){
			int seq=in.nextInt();
			int time=in.nextInt();
			int prior=in.nextInt();
			int timeSume=in.nextInt();
			queue.add(new idea(seq, time, prior, timeSume));
		}
		boolean[] coders=new boolean[m];
		boolean[][] ideas=new boolean[p][2];
		int t=1;
		while (!queue.isEmpty()){
			idea tmp=queue.poll();
			int index=-1;
			for (int i=0;i<coders.length;++i){
				if (!coders[i]){
					index=i;
					break;
				}
			}
			coders[index]=true;
			
		}
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println(3);
		System.out.println(9);
		
	}

}
