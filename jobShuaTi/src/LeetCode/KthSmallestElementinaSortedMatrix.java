package LeetCode;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pQueue=new PriorityQueue<>((x,y)->y-x);
        if (matrix==null || matrix.length==0) return 0;
        int n=matrix.length;
        for (int i=0;i<n;++i) {
        	for(int j=0;j<n;++j) {
        		if (pQueue.size()<k) {
        			pQueue.add(matrix[i][j]);
        		}else {
        			if (matrix[i][j]<pQueue.peek()) {
        				pQueue.poll();
        				pQueue.add(matrix[i][j]);
        			}
        		}
        	}
        }
        return pQueue.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
