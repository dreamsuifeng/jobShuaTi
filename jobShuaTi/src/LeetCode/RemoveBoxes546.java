package LeetCode;

import java.util.HashMap;

public class RemoveBoxes546 {
	HashMap<String, Integer> map=new HashMap<>();
	public String toString(int[] d){
		String res="";
		for (int i:d){
			res=res+i+",";
		}
		return res;
	}
	
	public int removeBoxes(int[] boxes) {
		int n = boxes.length;
	    int[][][] dp = new int[n][n][n];
	    return removeBoxesSub(boxes, 0, n - 1, 0, dp);
   
    }
	private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
	    if (i > j) return 0;
	    if (dp[i][j][k] > 0) return dp[i][j][k];
	        
	    int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);
	        
	    for (int m = i + 1; m <= j; m++) {
	        if (boxes[i] == boxes[m]) {
	            res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
	        }
	    }
	        
	    dp[i][j][k] = res;
	    return res;
	}
	private int remove(int[] boxes, int cur){
		String tmp=toString(boxes);
		if (map.containsKey(tmp)) return map.get(tmp);
		int n=boxes.length;
		
		
		int s=0;
		int maxValue=0;
		for (int i=1;i<=n;++i){
			if (i==n || boxes[i]!=boxes[i-1]){
				int sameCount=i-s;
				if (sameCount==n) {
					
					return cur+n*n;
				}
				int[] newBoxes=new int[n-sameCount];
				int index=0;
				for (int j=0;j<s;j++){
					newBoxes[index++]=boxes[j];
				}
				for (int j=i;j<n;++j){
					newBoxes[index++]=boxes[j];
				}
				maxValue=Math.max(maxValue,remove(newBoxes, cur+sameCount*sameCount));
				s=i;
			}
		}
		map.put(tmp, maxValue);
		return maxValue;
	}
	
	public static void main(String[] args) {
		// TODO Au	to-generated method stub
		RemoveBoxes546 t=new RemoveBoxes546();
		int[] data={1,3,2,2,2,3,4,3,1};
		System.out.println(t.removeBoxes(data));
	}

}
