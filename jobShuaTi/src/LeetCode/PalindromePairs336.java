package LeetCode;

import java.util.Arrays;
import java.util.Collections;
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
//    public List<List<Integer>> palindromePairs(String[] words) {
//        int n=words.length;
//        List<List<Integer>> res= new LinkedList<List<Integer>>();
//        for (int i=0;i<n;++i){
//            for (int j=i+1;j<n;++j){
//                if (isTrue(words[i]+words[j])){
//                    res.add(Arrays.asList(i,j));
//                    if (words[i].length()==words[j].length()){
//                    	res.add(Arrays.asList(j,i));
//                    }
//                }
//                if(isTrue(words[j]+words[j])){
//            	res.add(Arrays.asList(j,i));
//            }
//        }
//        }
//        return res;
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePairs336 t=new PalindromePairs336();
		System.out.println(t.isTrue("s"+"abcd"));
//		System.out.println(Arrays.asList(1,2));
	}

}
