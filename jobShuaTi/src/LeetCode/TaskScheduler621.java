package LeetCode;

import java.util.Arrays;

public class TaskScheduler621 {
	public int leastInterval(char[] tasks, int n) {
		if(tasks==null || tasks.length==0) return 0;
        int[] count=new int[26];
        for (char c:tasks){
        	count[c-'A']++;
        }
        int res=0;
       for(int j=0;j<tasks.length;){
        	int tmp = 0;
	        for (int i=0;i<26;++i){
	        	if (--count[i]>=0) {
	        		res++;
	        		tmp++;
	        		j++;
	        	}
	        }
	        if (tmp<n && j<tasks.length )
	        	res+=n-tmp+1;
	        
        }
        return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
