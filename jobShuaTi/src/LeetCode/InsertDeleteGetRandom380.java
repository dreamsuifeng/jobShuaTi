package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom380 {
	Set<Integer> data;
	Random rd;
	/** Initialize your data structure here. */
    public InsertDeleteGetRandom380() {
        data=new HashSet<>();
        rd=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return data.add(val);
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return data.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	int r=rd.nextInt(data.size());
        return new ArrayList<>(data).get(r);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		System.out.println(random.nextInt(6));
		System.out.println(random.nextInt(6));
		System.out.println(random.nextInt(6));
		System.out.println(random.nextInt(6));
	}	

}
