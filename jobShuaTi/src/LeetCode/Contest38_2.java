package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Contest38_2 {
	public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1]==o2[1]){
					return o1[0]-o2[0];
				}else{
					return o1[1]-o2[1];
				}
			}
		});
//		Arrays.sort(courses);
//        for(int[] i: courses){
//		    System.out.println(i[0]+","+i[1]);
//		}
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int res=0;
        int pre=0;
        for(int[] i:courses){
        	int t=i[0],d=i[1];
        	pre+=t;
        	pq.add(t);
        	while(pre>d){
        		pre-=pq.poll();
        	}
        }
        return pq.size();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t={{5,5},{4,6},{2,6}};
		System.out.println(scheduleCourse(t));
	}

}
