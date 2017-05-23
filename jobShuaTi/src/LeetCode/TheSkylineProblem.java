package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class TheSkylineProblem {
	public static List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> result = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b:buildings) {
	        // start point has negative height value
	        height.add(new int[]{b[0], -b[2]});
	        // end point has normal height value
	        height.add(new int[]{b[1], b[2]}); 
	    }

	    // sort $height, based on the first value, if necessary, use the second to
	    // break ties
	    Collections.sort(height, (a, b) -> {
	            if(a[0] != b[0]) 
	                return a[0] - b[0];
	            return a[1] - b[1];
	    });

	    // Use a maxHeap to store possible heights
	    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

	    // Provide a initial value to make it more consistent
	    pq.offer(0);

	    // Before starting, the previous max height is 0;
	    int prev = 0;

	    // visit all points in order
	    for(int[] h:height) {
	        if(h[1] < 0) { // a start point, add height
	            pq.offer(-h[1]);
	        } else {  // a end point, remove height
	            pq.remove(h[1]);
	        }
	        int cur = pq.peek(); // current max height;
	  
	        // compare current max height with previous max height, update result and 
	        // previous max height if necessary
	        if(prev != cur) {
	            result.add(new int[]{h[0], cur});
	            prev = cur;
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] test=new int[]{3,2,1,4,5,6,8,9};
//		Arrays.sort(test,new Comparator<Integer>(){
//			public int compare(Integer o1, Integer o2){
//				return o2-o1;
//			}
//		});
		int[][] test=new int[][]{ {2, 9,10}, {3, 7, 15}, {5,12, 12}, {15, 20,10}, {19, 24, 8} }; 
		System.out.println(getSkyline(test));
		}
	}

