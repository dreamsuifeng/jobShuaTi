package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];
	    ArrayList<Integer> res=new ArrayList<>();	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }
	    
	    int count = 0;
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        res.add(course);
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    if (count==numCourses){
	    	int[] result=new int[res.size()];
	    	for (int i=0;i<res.size();++i){
	    		result[i]=res.get(i);
	    	}
	    	return result;
	    }else {
	    	int[] result = new int[0];
			return result;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
