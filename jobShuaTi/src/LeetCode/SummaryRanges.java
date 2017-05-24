package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res= new LinkedList<>();
        int n=nums.length;
        if (n==0) return res;
        int premin=nums[0];
        int preMax=nums[0];
        for (int i=1;i<n;++i){
        	if (nums[i]!=preMax+1){
        		if (premin==preMax){
        			res.add(String.valueOf(premin));
        		}else{
        			res.add(String.valueOf(premin)+"->"+String.valueOf(preMax));
        		}
        		premin=nums[i];
        		preMax=nums[i];
        	}else{
        		preMax=nums[i];
        	}
        }
        if (premin==preMax){
			res.add(String.valueOf(premin));
		}else{
			res.add(String.valueOf(premin)+"->"+String.valueOf(preMax));
		}
        return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
