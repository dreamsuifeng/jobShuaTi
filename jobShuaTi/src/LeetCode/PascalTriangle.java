package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if (numRows==0){
        	return result;
        }
//        result.add(new ArrayList<Integer>());
        for (int i=0;i<numRows;++i){
        	ArrayList<Integer> tmpList=new ArrayList<Integer>();
        	tmpList.add(1);
        	if (i>1) {
        		List<Integer> preList=result.get(i-1);
            	for (int j=1;j<i;++j){
            		tmpList.add(preList.get(j-1)+preList.get(j));
            	}
			}
        	if (i>0) tmpList.add(1);
        	
        	result.add(tmpList);
        }
        return result;
    }
	public static void  main(String[] args) {
		PascalTriangle test=new PascalTriangle();
		System.out.println(Integer.MIN_VALUE-5);
		
	}
}
