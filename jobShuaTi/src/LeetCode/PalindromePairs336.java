package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairs336 {
	public boolean isTrue(String s){
        char[] sch=s.toCharArray();
        int l=s.length();
        if (l==1) return true;
        int i=0,j=l-1;
        while(i<j && sch[i]==sch[j]){
            i++;
            j--;
        }
        if (i==j || i==j+1) return true;
        else return false;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        int n=words.length;
        List<List<Integer>> res= new LinkedList<List<Integer>>();
        for (int i=0;i<n;++i){
            for (int j=i+1;j<n;++j){
                if (isTrue(words[i]+words[j])){
                    res.add(Arrays.asList(i,j));
                    if (words[i].length()==words[j].length()){
                    	res.add(Arrays.asList(j,i));
                    }
                }
                if(words[i].length()!=words[j].length() && isTrue(words[j]+words[i])){
                	res.add(Arrays.asList(j,i));
            }
        }
        }
        return res;
    }
    public List<List<Integer>> palindromePairs1(String[] words) {
        int n=words.length;
        List<List<Integer>> res= new LinkedList<List<Integer>>();
        HashMap<String, Integer> map=new HashMap<>();
        int i=0;
        for (String s:words){
        	map.put(s, i);
        	i++;
        }
        for (int j=0;j<n;++j){
        	for (int k=0;k<=words[j].length();++k){
        		String str1=words[j].substring(0, k);
        		String str2=words[j].substring(k);
        		if (isTrue(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != j) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(j);
                        res.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isTrue(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != j && str2.length()!=0) { 
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(j);
                        list.add(map.get(str1rvs));
                        res.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        	}
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePairs336 t=new PalindromePairs336();
//		System.out.println(t.isTrue("s"+"abcd"));
		String[] teStrings={"abcd", "dcba", "lls", "s", "sssll"};
		System.out.println(t.palindromePairs1(teStrings));
//		System.out.println(Arrays.asList(1,2));
	}

}
