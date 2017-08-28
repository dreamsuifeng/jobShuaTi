package LeetCode;

import java.util.*;

public class MinimumIndexSumofTwoLists599 {
	 public String[] findRestaurant(String[] list1, String[] list2) {
		 	HashMap<String, Integer> map1=new HashMap<>();
		 	for (int i=0;i<list1.length;++i){
		 		map1.put(list1[i], i);
		 	}
		 	int min=Integer.MAX_VALUE;
		 	List<String> reStrings=new LinkedList<>();
		 	for (int i=0;i<list2.length;++i){
		 		if (map1.containsKey(list2[i])){
		 			if (i+map1.get(list2[i])<min){
		 				min=i+map1.get(list2[i]);
		 				reStrings.clear();
		 				reStrings.add(list2[i]);
		 			}else if (i+map1.get(list2[i])==min){
		 				reStrings.add(list2[i]);
		 			}
		 		}
		 	}
		 	String[] res=new String[reStrings.size()];
		 	for (int i=0;i<res.length;++i){
		 		res[i]=reStrings.get(i);
		 	}
		 	return res;
		 	 
		 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
