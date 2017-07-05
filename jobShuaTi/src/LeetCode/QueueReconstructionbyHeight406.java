package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionbyHeight406 {
	private void insert(int index,int[][] a,int[] id,int size){
		int n=a.length;
		if (index==n-1){
			a[index]=id;
		}
		for (int i=size-1;i>=index;--i){
			a[i+1]=a[i];
		}
		a[index]=id;
	}
	public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(x,y)->(x[0]!=y[0] ? y[0]-x[0]:x[1]-y[1]));
        int[][] res=new int[people.length][2];
        int size=0;
        for (int i=0;i<people.length;++i){
        	insert(people[i][1], res, people[i], size);
        	size++;
        }
        return res;
        
    }
}
