package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Contest402 {
	 public static String solveEquation1(String equation) {
	    	String[] parts = equation.split("=");
	    	List<Integer> leftSide = parse(parts[0]);
	    	List<Integer> rightSide = parse(parts[1]);
	    	int xC = leftSide.get(0) - rightSide.get(0);
	    	int c = rightSide.get(1) - leftSide.get(1);
	    	if (xC == 0) {
	    		if (c == 0) {
	    			return "Infinite solutions";
	    		} else {
	    			return "No solution";
	    		}
	    	}
	    	return "x=" + c / xC;
	    }
		
		private static List<Integer> parse(String string) {
			int xC = 0;
			int c = 0;
			boolean positive = true;
			String args = "";
			for (int i = 0; i < string.length(); i++) {
				char curr = string.charAt(i);
				if (curr ==  '+' || curr == '-') {
					if (!args.isEmpty()) {
						if (args.endsWith("x")) {
							args = args.substring(0, args.length()-1);
							if (args.isEmpty()) {
								xC = positive ? xC + 1 : xC - 1;
							} else {
								int n = Integer.valueOf(args);
								xC = positive ? xC + n : xC - n;
							}
						} else {
							int n = Integer.valueOf(args);
							c = positive ? c + n : c - n;
						}
					}
					args = "";
					positive = curr == '+';
				} else {
					args = args + curr;
				}
			}
			if (args.endsWith("x")) {
				args = args.substring(0, args.length()-1);
				if (args.isEmpty()) {
					xC = positive ? xC + 1 : xC - 1;
				} else {
					int n = Integer.valueOf(args);
					xC = positive ? xC + n : xC - n;
				}
			} else {
				int n = Integer.valueOf(args);
				c = positive ? c + n : c - n;
			}
			return Arrays.asList(xC, c);
		}
	public static String solveEquation(String equation) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        char[] es=equation.toCharArray();
        int value=0;
        boolean flag=true;
        boolean equalpre=true;
        for (char c:es){
        	if (Character.isDigit(c)){
        		value=value*10+Integer.parseInt(""+c);
        	}
        	else if (c=='x'){
        		int pre=s2.isEmpty() ? 0:s2.pop();
        		if (flag){
	        		if (value==0){
	        			if(equalpre){
	        				s2.add(pre-1);
	        			}
	        			else {
							s2.add(pre+1);
						}
	        		}else{
	        			if (equalpre){
	        				s2.add(pre-value);
	        			}else{
	        				s2.add(pre+value);
	        			}
	        			
	        		}
        		}else{
        			if (value==0){
        				if (equalpre){
        					s2.add(pre+1);
        				}else{
        					s2.add(pre-1);
        				}
        				
	        		}else{
	        			if (equalpre){
	        				s2.add(pre+value);
	        			}else{
	        				s2.add(pre-value);	
	        			}
	        			
	        		} 
        		}
        		value=0;
        	}else if (c=='='){
        		if (value>0){
        			int pre=s1.isEmpty() ? 0:s1.pop();
            		int sum=0;
            		if(flag){
            			if (equalpre)
            				sum=pre+value;
            			else sum=pre-value;
            		}else{
            			if (equalpre)
            				sum=pre-value;
            			else sum=pre+value;
            		}
            		
        			s1.add(sum);
            		if (c=='-') flag=false;
            		else flag=true;
            		value=0;
        		}
        		equalpre=false;
        		flag=true;
        		continue;
        	}else{
        		int pre=s1.isEmpty() ? 0:s1.pop();
        		int sum=0;
        		if(flag){
        			if (equalpre)
        				sum=pre+value;
        			else sum=pre-value;
        		}else{
        			if (equalpre)
        				sum=pre-value;
        			else sum=pre+value;
        		}
        		
    			s1.add(sum);
        		if (c=='-') flag=false;
        		else flag=true;
        		value=0;
        	}
        }
        if (value>0){
			int pre=s1.isEmpty() ? 0:s1.pop();
    		int sum=0;
    		if(flag){
    			if (equalpre)
    				sum=pre+value;
    			else sum=pre-value;
    		}else{
    			if (equalpre)
    				sum=pre-value;
    			else sum=pre+value;
    		}
    		
			s1.add(sum);
		}
        if (s1.isEmpty() && s2.isEmpty()) return "Infinite solutions";
        if (s1.peek()==0 && s2.peek()==0) return "Infinite solutions";
        if (!s2.isEmpty()){
        	int sum=s1.isEmpty() ? 0:s1.pop();
        	int q=s2.pop();
        	return q==0 ? "No solution":"x="+sum/q;
        }
        return ""; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solveEquation("1-x+x-x+x+x=-99-2x+x-x+x"));
	}

}
