package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WiggleSubsequence376 {
	public static int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        Set<ArrayList<Integer>> preMaxlen=new HashSet<>();
        for (int i=0;i<n;++i){
        	ArrayList<Integer> tmp=new ArrayList<>();
        	if (preMaxlen.size()==0){
        		tmp.add(nums[i]);
        		preMaxlen.add(tmp);
        	}else{
        		Set<ArrayList<Integer>> newList=new HashSet<>();
        		for (ArrayList<Integer> al:preMaxlen){
        			if (al.size()==1){
        				al.add(nums[i]);
        			}else{
        				int pre=al.get(al.size()-1);
        				int pre2=al.get(al.size()-2);
        				if ((nums[i]-pre)*(pre-pre2)<0){
        					al.add(nums[i]);
        				}
        				if ((nums[i]>pre2 && pre>pre2)|| (nums[i]<pre2 && pre<pre2)){
        					ArrayList<Integer> copy=new ArrayList<>(al);
        					copy.remove(al.size()-1);
        					copy.add(nums[i]);
        					newList.add(copy);
        				}
        			}
        		}
        		if (newList.size()>0){
        			preMaxlen.addAll(newList);
        		} 
        	}
        	
        }
//        System.out.println(preMaxlen.toString());
        return preMaxlen.iterator().next().size();
    }
	
	public static int wiggleMaxLength1(int[] nums) {
		int n=nums.length;
		int[] dp=new int[n];
		int[] labels=new int[n];
		int res=0;
		dp[0]=1;
		for (int i=1;i<n;++i){
			int t=0;
			int flag=2;
			for (int j=i-1;j>=0;--j){
				if (nums[i]>nums[j] && (j==0 || labels[j]==-1)){
					if (dp[j]+1>t){
						t=dp[j]+1;
						flag=1;
					}
				}
				else if (nums[i]<nums[j] && (j==0 || labels[j]==1)){
					if (dp[j]+1>t){
						t=dp[j]+1;
						flag=-1;
					}
				}
			}
			dp[i]=t;
			labels[i]=flag;
			res=Math.max(res, t);
		}
		return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Set<ArrayList<Integer>> set=new HashSet<>();
//		ArrayList<Integer> t=new ArrayList<>();
//		t.add(1);
//		t.add(2);
//		set.add(t);
//		set.add(t);
//		System.out.println(set.toString());
		System.out.println(wiggleMaxLength1(new int[]{1,2,3,4,5,6,7,8,9}));
	}

}
