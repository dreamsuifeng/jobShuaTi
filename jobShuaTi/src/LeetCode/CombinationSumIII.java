package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Templates;

public class CombinationSumIII {
	private List<List<Integer>> res=new ArrayList<>();
	private Set<Integer> set=new HashSet<>();
	private List<Integer> tmp = new ArrayList<>();
 	public void find(int k, int n, int start){
 		if (n==0 && k==0){
			res.add(new ArrayList<>(tmp));
//			set.remove(tmp.get(tmp.size()-1));
//			tmp.remove(tmp.size()-1);
			
			return;
			}
 		if (n==0 || k==0){
// 			set.remove(tmp.get(tmp.size()-1));
// 			tmp.remove(tmp.size()-1);
 			return;
 		}
        for (int i=start;i<=9;++i){
        	 if(set.contains(i)) continue;
        	tmp.add(i);
        	set.add(i);
        	find(k-1, n-i,i+1);
        	set.remove(tmp.get(tmp.size()-1));
    		tmp.remove(tmp.size()-1);
        }
        
 	}
	public List<List<Integer>> combinationSum3(int k, int n) {
		find(k, n,1);
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumIII test=new CombinationSumIII();
		System.out.println(test.combinationSum3(3, 9));
	}

}
