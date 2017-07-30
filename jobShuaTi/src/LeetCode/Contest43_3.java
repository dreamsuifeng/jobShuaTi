package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Contest43_3 {
	public static String predictPartyVictory(String senate) {
    	Queue<Integer> q = new ArrayDeque<>();
    	int[] rem = new int[2];
    	for(char s : senate.toCharArray()){
    		q.add(s == 'R' ? 0 : 1);
    		rem[s == 'R' ? 0 : 1]++;
    	}
    	int[] die = new int[2];
    	while(true){
    		if(rem[0] == 0)return "Dire";
    		if(rem[1] == 0)return "Radiant";
    		int cur = q.poll();
    		if(die[cur] > 0){
    			die[cur]--;
    			rem[cur]--;
    			continue;
    		}
    		q.add(cur);
    		die[cur^1]++;
    	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(predictPartyVictory("DDRRR"));
	}

}
