package LeetCode;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons452 {
	public int findMinArrowShots(int[][] points) {
        if (points==null || points.length==0 || points[0].length==0) return 0;
        Arrays.sort(points, (x,y)-> (x[0]!=y[0] ? x[0]-y[0]:x[1]-y[1]));
        int minCount=1;
        int Arrowlast=points[0][1];
        for (int i=1;i<points.length;++i){
        	if (points[i][0]<=Arrowlast){
        		Arrowlast=Math.min(Arrowlast, points[i][1]);
        	}else{
        		minCount++;
        		Arrowlast=points[i][1];
        	}
        }
        return minCount;
    }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
