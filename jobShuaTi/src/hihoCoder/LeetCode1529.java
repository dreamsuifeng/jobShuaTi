package hihoCoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LeetCode1529 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		long[] nums=new long[n];
		for (int i=0;i<n;++i){
			nums[i]=in.nextLong();
		}
		PriorityQueue<Long> Q=new PriorityQueue<>(16,new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				// TODO Auto-generated method stub
				return (int) (o2-o1);
			}
			
		});
		Long t=nums[n-1];
		long res=0;
		Q.add((long) t);
		for (int i=n-2;i>=0;--i){
			t=nums[i];
			Q.add((long) t);
			if (Q.peek()>t){
				res+=Q.peek()-t;
				Q.poll();
				Q.add((long) t);
			}
		}
		System.out.println(res);
	}
}
