package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;




public class IncreasingSubsequences491 {
	private String toString(List<Integer> l){
		StringBuffer sb=new StringBuffer();
		for (Integer i:l){
			sb.append(i+"#");
		}
		return sb.toString().substring(0,sb.length()-1);
	}
	private HashSet<String> used=new HashSet<>();
	
	
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res=new ArrayList<>();
		for (int i=0;i<nums.length;++i){
			
			List<List<Integer>> tlList=new ArrayList<>();
			for (int j=0;j<res.size();++j){
				List<Integer> tmp=res.get(j);
				if (nums[i]>=tmp.get(tmp.size()-1)){
					String news=toString(tmp)+nums[i];
					if (!used.contains(news)){
						
						
							ArrayList<Integer> tmplist=new ArrayList<>();
                            tmplist.addAll(tmp);
							tmplist.add(nums[i]);
							tlList.add(tmplist);
                            used.add(news);
						
				}
				}
			}
			res.addAll(tlList);
			ArrayList<Integer> l=new ArrayList<>();
			l.add(nums[i]);
			res.add(l);
		}
		List<List<Integer>> result=new ArrayList<>();
		for (int i=0;i<res.size();++i){
			if (res.get(i).size()>1){
				result.add(res.get(i));
			}
		}
		return result;
		
    }
}
