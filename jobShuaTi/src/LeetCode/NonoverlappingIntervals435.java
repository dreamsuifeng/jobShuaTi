package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.x500.X500Principal;

public class NonoverlappingIntervals435 {
	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,(x,y)->x.end-y.end);
        int end=intervals[0].end;
        int count=0;
        for(int i=1;i<intervals.length;++i){
        	if (intervals[i].start>=end){
        		count++;
        		end=intervals[i].end;
        	}
        }
        return intervals.length-count;
    }
	class IntervalIndex extends Interval{
		int index;
		public IntervalIndex(int index,int s,int e){
			super(s,e);
			this.index=index;
		}
	}
	int binsearch(int start,int end,ArrayList<IntervalIndex> d,int v){
		if (start>end) return -1;
		int mid=start+(end-start)/2;
		if (d.get(mid).start==v){
			return d.get(mid).index;
		}else if (d.get(mid).start<v){
			
			if (start==end) {
				int index=d.get(mid).index+1;
				return index<d.size() ? index:-1;
			}
			return binsearch(mid+1, end, d, v);
		}else{
			if (start==end) return d.get(mid).index;
			return binsearch(start, mid-1, d, v);
		}
	}
	public int[] findRightInterval(Interval[] intervals) {
        int[] res=new int[intervals.length];
        ArrayList<IntervalIndex> d=new ArrayList<>();
        int index=0;
        for (Interval i:intervals){
        	d.add(new IntervalIndex(index, i.start, i.end));
        	index++;
        }
        Collections.sort(d,(x,y)->x.start-y.start);
        for (int i=0;i<d.size();++i){
        	res[d.get(i).index]=binsearch(i+1, d.size()-1, d, d.get(i).end);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
