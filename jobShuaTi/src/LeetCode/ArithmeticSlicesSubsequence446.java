package LeetCode;

import java.util.HashMap;

public class ArithmeticSlicesSubsequence446 {
	public int numberOfArithmeticSlices(int[] A) {
		int re=0;
		HashMap<Integer, Integer>[] maps=new HashMap[A.length];
		for(int i=0;i<A.length;++i){
			maps[i]=new HashMap<>();
			for (int j=0;j<i;++j){
				long diff=(long)A[i]-A[j];
				if (diff>Integer.MAX_VALUE || diff<Integer.MIN_VALUE) continue;
				int count=maps[j].getOrDefault(diff, 0);
				maps[i].put((int) diff, maps[i].getOrDefault(diff, 0)+count+1);
				re+=count;
			}
		}
		return re;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
