package LeetCode;

import java.util.PriorityQueue;

public class RelativeRanks506 {
	public String[] findRelativeRanks(int[] nums) {
		if (nums==null || nums.length==0) return new String[0];
        String[] res=new String[nums.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->y[1]-x[1]);
        for (int i = 0;i<nums.length;++i){
        	int[] t=new int[2];
        	t[0]=i;
        	t[1]=nums[i];
        	pq.add(t);
        }
        int i=0;
        while (!pq.isEmpty()){
        	if (i==0){
        		res[pq.peek()[0]]="Gold Medal";
        	}else if(i==1){
        		res[pq.peek()[0]]="Silver Medal";
        	}else if (i==2){
        		res[pq.peek()[0]]="Bronze Medal";
        	}else{
        		res[pq.peek()[0]]=""+(i+1);
        	}
        	i++;
        	pq.poll();
        }
        return res;
    }
}
