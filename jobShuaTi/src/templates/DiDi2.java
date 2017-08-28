package templates;

import java.util.*;
public class DiDi2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String[] line=in.nextLine().split(" ");
		PriorityQueue<Integer> pQueue=new PriorityQueue<>();
		
		int k=Integer.parseInt(in.nextLine());
		for (int i=0;i<line.length;++i){
			int d=Integer.parseInt(line[i]);
			if (pQueue.size()<k){
				pQueue.add(d);
			}else {
				if (pQueue.peek()>=d){
					continue;
				}else{
					pQueue.poll();
					pQueue.add(d);
				}
			}
		}
		System.out.println(pQueue.peek());
	}

}
