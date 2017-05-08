package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
//	private ArrayList<Integer> mumPaths=new ArrayList<Integer>();
	private int minMum=Integer.MAX_VALUE;
	private ArrayList<Integer> pathSum=new ArrayList<Integer>();
	public void minPath(List<List<Integer>> triangle, int tempMum, int nRows, int i, int j){
		if (i==nRows){
			if (tempMum<minMum){
				minMum=tempMum;
			}
			return;
		}

		minPath(triangle, tempMum+triangle.get(i).get(j) , nRows, i+1, j);
		minPath(triangle, tempMum+triangle.get(i).get(j+1), nRows, i+1, j+1);
		
	}
	public void minPath1(List<List<Integer>> triangle, int nRows){
		ArrayList<Integer> temp=new ArrayList<Integer>();
		temp.add(triangle.get(0).get(0));
		for (int i=1;i<nRows;++i){
			List<Integer> tp1=triangle.get(i);
			pathSum.clear();
			for (int j=0;j<tp1.size();++j){
				int a=tp1.get(j)+temp.get(j);
				int b=Integer.MAX_VALUE;
				if (j-1>=0){
					b=tp1.get(j)+temp.get(j-1);
				}
				int minTemp= a<b ? a:b;
				pathSum.add(minTemp);
				if (i==nRows-1 && minTemp<minMum ){
					minMum=minTemp;
				}
			}
			temp=new ArrayList<Integer>(pathSum);
		}
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.isEmpty()){
			return 0;
		}
		minPath1(triangle, triangle.size());
        return minMum;
        
    }
}
