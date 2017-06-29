package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LexicographicalNumbers386 {
	private List<Integer> res=new ArrayList<>();
	public void solve(int n, int pre){
		if (pre>n) return;
		res.add(pre);
		for (int i=0;i<=9;++i){
			if (pre==0 && i==0){
				continue;
			}
			solve(n, pre*10+i);
		}
	}
	public List<Integer> lexicalOrder(int n) {
        solve(n, 1);
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("a">"b");
		System.out.println(new LexicographicalNumbers386().lexicalOrder(20));
	}

}
