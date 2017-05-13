package LeetCode;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.math.BigDecimal;


public class MaxPointsonaLine {
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	private int res=0;
	private HashMap<String, String> xielu=new HashMap<>();
	private int parisValue=0;
// compute max count one line counts
	private static int gcd(int a, int b) {
		 while(b != 0) {
		  int temp = a%b;
		  a = b;
		  b = temp;
		 }
		 return a;
		 }

	public int maxPoints(Point[] points) {
		
		int n=points.length;
		if (n==0 || n==1 ||n==2){
		    return n;
		}
        for (int i=0;i<n;++i){
        	Map<String, Integer> map=new HashMap<>();
        	int rest=0;
        	int duplicateds=0;
        	for (int j=0; j<n;++j){
        		if (j==i) continue;
        		if(points[j].x==points[i].x && points[j].y==points[i].y){
        					duplicateds++;
        					continue;
        				}
        		String temp=Integer.toString(i)+","+Integer.toString(j);
        		String temp2=Integer.toString(j)+","+Integer.toString(i);
        		if (xielu.containsKey(temp)){
        			String dtemp=xielu.get(temp);
        			
        			if (map.containsKey(dtemp)){
        				map.put(dtemp, map.get(dtemp)+1);
        				
        			}else{
        				map.put(dtemp, 2);
        				rest = rest<2 ? 2:rest;
        			}
        			int t=map.get(dtemp);
    				rest = rest<t ? t:rest;
        		}else{
        			String xieluTmp="";
//        			if (points[j].x!=points[i].x){
    				int X=points[j].x-points[i].x;
    				int Y=points[j].y-points[i].y;
    				int gcdI=gcd(X, Y);
    				xieluTmp=""+(X/gcdI+"/"+Y/gcdI);
        				
//        			}else{
//        				
//        				xieluTmp=Double.MAX_VALUE;
//        			}
        			xielu.put(temp, xieluTmp);
        			xielu.put(temp2, xieluTmp);
        			if (map.containsKey(xieluTmp)){
        				map.put(xieluTmp,map.get(xieluTmp)+1);
        				
        			}else{
        				map.put(xieluTmp, 2);
        			}
        			int t=map.get(xieluTmp);
        			
    				rest = rest<t ? t:rest;
        		}
        		
        		
        		
        	}
        	rest+= rest==0 ? duplicateds+1:duplicateds;
        	res=res<rest ? rest:res;
        }
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(3, 0));
	}
//	[[0,9],
//	 [138,429],
//	 [115,359],
//	 [115,359],
//	 [-30,-102],
//	 [230,709],
//	 [-150,-686],
//	 [-135,-613],
//	 [-60,-248],
//	 [-161,-481],
//	 [207,639],
//	 [23,79],
//	 [-230,-691],
//	 [-115,-341],
//	 [92,289],
//	 [60,336],
//	 [-105,-467],
//	 [135,701],
//	 [-90,-394],
//	 [-184,-551],
//	 [150,774]]


}
