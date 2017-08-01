package LeetCode;

import java.util.Arrays;

public class Heaters475 {
	public int findRadius(int[] houses, int[] heaters) {
		int res=0;
        Arrays.sort(heaters);
        for (int house:houses){
        	int index=Arrays.binarySearch(heaters, house);
        	if (index<0){
        		index=-(index+1);
        		
        	}
        	int d1=index-1>=0 ? house-heaters[index-1]:Integer.MAX_VALUE;
        	int d2=index<heaters.length ? heaters[index]-house:Integer.MAX_VALUE;
        	res=Math.max(res, Math.min(d1, d2));
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
