package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums373 {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1=nums1.length;
        int n2=nums2.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->(y[0]+y[1]-x[0]-x[1]));
        for (int i=0;i<n1;++i){
        	for (int j=0;j<n2;++j){
        		int[] tmp=new int[2];
        		tmp[0]=nums1[i];
        		tmp[1]=nums2[j];
        		if (pq.size()<k){
        			pq.add(tmp);
        		}else{
        			int[] t=pq.peek();
        			if (t[0]+t[1]>tmp[0]+tmp[1]){
        				pq.poll();
        				pq.add(tmp);
        			}
        		}
        	}
        }
        List<int[]> res=new LinkedList<>();
        Iterator<int[]> it=pq.iterator();
        while(it.hasNext()){
        	res.add(pq.poll());
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
