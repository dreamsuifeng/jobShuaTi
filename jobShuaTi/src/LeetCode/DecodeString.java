package LeetCode;

import java.awt.image.RescaleOp;
import java.util.Stack;
import java.util.StringTokenizer;

public class DecodeString {
	public String decodeString(String s) {
		if (s=="" || s.length()==0) return "";
        char[] ch=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        StringBuffer buffer=new StringBuffer();
        int n=ch.length;
        for (int i=0;i<n;++i){
        	if (ch[i]==']'){
        		StringBuffer tmp=new StringBuffer();
        		while (!stack.isEmpty() && !Character.isDigit(stack.peek()) && stack.peek()!='['){
        			tmp.insert(0, stack.pop());
        		}
        		StringBuffer num=new StringBuffer();
        		stack.pop();
        		while(!stack.isEmpty() && Character.isDigit(stack.peek())){
        			num.insert(0, stack.pop());
        		}
        		int number=Integer.parseInt(num.toString());
        		char[] inString=tmp.toString().toCharArray();
        		for (int j=0;j<number;++j){
        			for (int k=0;k<inString.length;++k){
        				stack.push(inString[k]);
        			}
        		}
        	}else{
        		stack.push(ch[i]);
        	}
        	
        	
        }
      while(!stack.isEmpty()){
    	  buffer.insert(0,stack.pop());
      }
      return buffer.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString tDecodeStrin=new DecodeString();
		System.out.println(tDecodeStrin.decodeString("3[a2[c]]"));
	}

}
