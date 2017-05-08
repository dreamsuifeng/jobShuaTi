package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class DistributeCandies {
	public int distributeCandies(int[] candies) {
        int kindSum=0;
        int countSum=0;
        HashSet<Integer> t=new HashSet<Integer>();
        for(int i=0;i<candies.length;++i){
            if (!t.contains(candies[i])){
            	t.add(candies[i]);
            	kindSum++;
            }
            countSum++;
        }
        if (countSum/2<kindSum){
        	return countSum/2;
        	
        }else{
        	return kindSum;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
