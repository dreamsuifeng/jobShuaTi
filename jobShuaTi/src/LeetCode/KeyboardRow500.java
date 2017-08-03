package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class KeyboardRow500 {
	public String[] findWords(String[] words) {
        String line1="qwertyuiop";
        String line2="asdfghjkl";
        String line3="zxcvbnm";
        List<String> res=new LinkedList<>();
        for (String s:words){
        	boolean flag=true;
        	int tmp=-1;
        	String ct=s.substring(0, 1).toLowerCase();
        	if (line1.contains(ct)){
        		tmp=1;
        	}else if (line2.contains(ct)){
        		tmp=2;
        	}
        	else{
        		tmp=3;
        	}
        	for (char c:s.toCharArray()){
        		char t=Character.toLowerCase(c);
        		if (line1.contains(String.valueOf(t))){
        			if(tmp!=1){
        				flag=!flag;
        				break;
        			}
        		}
        		else if (line2.contains(String.valueOf(t))){
        			if(tmp!=2){
        				flag=!flag;
        				break;
        			}
        		}
        		else if (line3.contains(String.valueOf(t))){
        			if(tmp!=3){
        				flag=!flag;
        				break;
        			}
        		}
        	}
        	if (flag){
        		res.add(s);
        	}
        }
        String[] ans=new String[res.size()];
        for (int i=0;i<res.size();++i){
        	ans[i]=res.get(i);
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(2^3);
	}

}
