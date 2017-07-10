package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class fourSum2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count=0;
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i:D){
			for (int j:C)
			map.compute(i+j, (k,v)->v==null ? 1:v+1);
		}
		
        for (int i=0;i<A.length;++i){
        	for (int j=0;j<B.length;++j){
        		
        			int key=A[i]+B[j];
        			if (map.containsKey(-key)){
        				count+=map.get(-key);
        			}
        		
        	}
        }
        return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
