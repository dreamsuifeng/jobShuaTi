package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
	        Stack<String> stack=new Stack<>();
	        for (String s:tokens){
	        	if (s.equals("+")){
	        		int s1=Integer.parseInt(stack.pop());
	        		int s2=Integer.parseInt(stack.pop());
	        		stack.push(String.valueOf(s1+s2));
	        	}else if (s.equals("-")){
	        		int s1=Integer.parseInt(stack.pop());
	        		int s2=Integer.parseInt(stack.pop());
	        		stack.push(String.valueOf(s2-s1));
	        	}else if (s.equals("*")){
	        		int s1=Integer.parseInt(stack.pop());
	        		int s2=Integer.parseInt(stack.pop());
	        		stack.push(String.valueOf(s1*s2));
	        	}else if (s.equals("/")){
	        		int s1=Integer.parseInt(stack.pop());
	        		int s2=Integer.parseInt(stack.pop());
	        		stack.push(String.valueOf(s2/s1));
	        	}else{
	        		stack.push(s);
	        	}
	    }
	        return Integer.parseInt(stack.pop());
	}
}
