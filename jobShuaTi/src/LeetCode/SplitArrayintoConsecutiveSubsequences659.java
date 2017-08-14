package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SplitArrayintoConsecutiveSubsequences659 {
	static class node{
		int count;
		int maxval;
	}
	public boolean isPossible(int[] nums) {
        ArrayList<node> used=new ArrayList<>();
        for (int i:nums){
        	int index=-1;
        	int count=Integer.MAX_VALUE;
        	for (int j=0;j<used.size();++j){
        		if (used.get(j).maxval+1==i && used.get(j).count<count){
        			index=j;
        			count=used.get(j).count;
        		}
        	}
        	if (index!=-1){
        		used.get(index).count++;
        		used.get(index).maxval++;
        	}else{
        		node t=new node();
        		t.maxval=i;
        		t.count=1;
        		used.add(t);
        	}
        }
        for (int i=0;i<used.size();++i){
        	if (used.get(i).count<3){
        		return false;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
