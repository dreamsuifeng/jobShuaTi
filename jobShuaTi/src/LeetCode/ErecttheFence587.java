package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class ErecttheFence587 {
	static class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		      @Override
		      public String toString(){
				return x+"-"+y;
		    	  
		      }
		  }
	
	 public static List<Point> outerTrees(Point[] points) {
	        if (points.length <= 1)
	            return Arrays.asList(points);
	        sortByPolar(points, bottomLeft(points));
	        Stack<Point> stack = new Stack<>(); 
	        stack.push(points[0]);                      
	        stack.push(points[1]);                              
	        for (int i = 2; i < points.length; i++) {
	            Point top = stack.pop();                                
	            while (ccw(stack.peek(), top, points[i]) < 0)
	                top = stack.pop();
	            stack.push(top);
	            stack.push(points[i]);
	        }       
	        return new ArrayList<>(stack);
	    }                               

	    private static Point bottomLeft(Point[] points) {
	        Point bottomLeft = points[0];
	        for (Point p : points)          
	            if (p.y < bottomLeft.y || p.y == bottomLeft.y && p.x < bottomLeft.x)
	                bottomLeft = p;                 
	        return bottomLeft;                                                  
	    }

	    /**
	     * @return positive if counter-clockwise, negative if clockwise, 0 if collinear
	     */
	    private static int ccw(Point a, Point b, Point c) {
	        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;       
	    }

	    /**
	     * @return distance square of |p - q|
	     */
	    private static int dist(Point p, Point q) {
	        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	    }
	                              
	    private static void sortByPolar(Point[] points, Point r) {
	        Arrays.sort(points, (p, q) -> {
	            int compPolar = ccw(p, r, q);
	            int compDist = dist(p, r) - dist(q, r); 
	            return compPolar == 0 ? compDist : compPolar;
	        });     
	        // find collinear points in the end positions
	        Point p = points[0], q = points[points.length - 1];
	        int i = points.length - 2;
	        while (i >= 0 && ccw(p, q, points[i]) == 0)
	            i--;    
	        // reverse sort order of collinear points in the end positions
	        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
	            Point tmp = points[l];
	            points[l] = points[h];
	            points[h] = tmp;
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] p={{3,7},{6,8},{7,8},{11,10},{4,3},{8,5},{7,13},{4,13}};
		Point[] points=new Point[p.length];
		for (int i=0;i<p.length;++i){
			Point pp=new Point(p[i][0],p[i][1]);
			points[i]=pp;
		}
		System.out.println(outerTrees(points).toString());
	}

}
