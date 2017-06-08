package otherAlgorithsTest;

import java.util.Stack;

public class AliInterview {
	public static boolean isTrue(String s){
		if (s.length()==0) return false;
		Stack<Character> stack=new Stack<>();
		for (int i=0;i<s.length();++i){
			if (s.charAt(i)=='('){
				stack.push('(');
			}else if (s.charAt(i)==')' && !stack.isEmpty()){
				stack.pop();
			}else if(s.charAt(i)==')' && stack.isEmpty()){
				return false;
			}
			else{
				continue;
			}
		}
		if (stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(-6));
		System.out.println(Integer.toBinaryString(6));
		
		
	}

}
