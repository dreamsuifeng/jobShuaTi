package LeetCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack=null;
	private Stack<Integer> minstack=null;
	private Map<Integer, Integer> map=null;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
        map=new HashMap<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (map.containsKey(x)){
        	map.put(x, map.get(x)+1);
        }else{
        	map.put(x, 1);
        }
        if (minstack.empty()) minstack.push(x);
        else if (x<minstack.peek()) minstack.push(x);
    }
    
    public void pop() {
        int temp=stack.pop();
        if (map.get(temp)==1){
        	map.remove(temp);
        }else{
        	map.put(temp, map.get(temp)-1);
        }
        if (temp==minstack.peek() && !map.containsKey(temp)) {
        	minstack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
