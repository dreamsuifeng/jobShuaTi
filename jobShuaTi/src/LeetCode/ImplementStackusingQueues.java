package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	public class MyStack {
		private Queue<Integer> queue;
	    /** Initialize your data structure here. */
	    public MyStack() {
	        queue=new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        queue.add(x);
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        Queue<Integer> help = new LinkedList<>();
	        while (!queue.isEmpty()){
	        	int tmp= queue.poll();
	        	if (queue.isEmpty()){
	        		queue=new LinkedList<>(help);
	        		return tmp;
	        	}
	        	help.add(tmp);
	        }
			return 0;
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	Queue<Integer> help = new LinkedList<>();
	        while (!queue.isEmpty()){
	        	int tmp= queue.poll();
	        	help.add(tmp);
	        	if (queue.isEmpty()){
	        		queue=new LinkedList<>(help);
	        		return tmp;
	        	}
	        	
	        }
			return 0;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
