package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PerfectRectangle391 {
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles==null || rectangles.length==0) return false;
        int n=rectangles.length;
        HashMap<String, Integer> map=new HashMap<>();
        long area=0;
        for (int i=0;i<n;++i){
        	String t1=String.valueOf(rectangles[i][0])+","+String.valueOf(rectangles[i][1]);
        	String t2=String.valueOf(rectangles[i][0])+","+String.valueOf(rectangles[i][3]);
        	String t3=String.valueOf(rectangles[i][2])+","+String.valueOf(rectangles[i][1]);
        	String t4=String.valueOf(rectangles[i][2])+","+String.valueOf(rectangles[i][3]);
        	map.compute(t1, (k,v)-> v==null ? 1:v+1);
        	map.compute(t2, (k,v)-> v==null ? 1:v+1);
        	map.compute(t3, (k,v)-> v==null ? 1:v+1);
        	map.compute(t4, (k,v)-> v==null ? 1:v+1);
        	area+=(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
        }
        ArrayList<int[]> points=new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
        	Map.Entry<String, Integer> tmp=it.next();
        	if (tmp.getValue()%2!=0){
        		int[] t=new int[2];
        		String[] s=tmp.getKey().split(",");
        		t[0]=Integer.valueOf(s[0]);
        		t[1]=Integer.valueOf(s[1]);
        		points.add(t);
        	}
        }
        if(points.size()!=4) return false;
        points.sort((x,y)->x[0]!=y[0] ? x[0]-y[0]:x[1]-y[1]);
        long s=(points.get(3)[1]-points.get(2)[1])*(points.get(2)[0]-points.get(0)[0]);
        if (area==s){
        	return true;
        }else{
        	return false;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
