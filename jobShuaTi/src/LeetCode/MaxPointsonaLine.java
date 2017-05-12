package LeetCode;
import java.lang.Math;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class MaxPointsonaLine {
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	private int res=0;
	private HashMap<String, Double> xielu=new HashMap<>();
// compute max count one line counts	
	public int maxPoints(Point[] points) {
		int n=points.length;
		if (n==0 || n==1 ||n==2){
		    return n;
		}
        for (int i=0;i<n;++i){
        	Map<Double, Integer> map=new HashMap<>();
        	int rest=0;
        	Set<String> used=new HashSet<>();
        	used.add(points[i].x+","+points[i].y);
        	for (int j=0; j<n;++j){
        		if (j==i) continue;
//        		if (used.contains((points[j].x+","+points[j].y))){
//        			rest++;
//        			continue;
//        		}else{
//        			used.add(points[j].x+","+points[j].y);
//        		}
        		String temp=Integer.toString(i)+Integer.toString(j);
        		String temp2=Integer.toString(j)+Integer.toString(i);
        		if (xielu.containsKey(temp)){
        			Double dtemp=xielu.get(temp);
        			if (map.containsKey(dtemp)){
        				map.put(dtemp, map.get(dtemp)+1);
        				int t=map.get(dtemp);
        				rest = rest<t ? t:rest;
        			}else{
        				map.put(dtemp, 2);
        				rest = rest<2 ? 2:rest;
        			}
        		}else{
        			double xieluTmp=0.0;
        			if (points[j].x!=points[i].x){
        				xieluTmp=(points[j].y-points[i].y)*1.0/(points[j].x-points[i].x);
        			}else{
        				if(points[j].x==points[i].x && points[j].y==points[i].y){
        					
        				}
        				else xieluTmp=Double.MAX_VALUE;
        			}
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
        	res=res<rest ? rest:res;
        }
        return res;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
