package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length-1;
	    int end = 0;
	    int sum = gas[start] - cost[start];
	    while (start > end) {
          if (sum >= 0) {
             sum += gas[end] - cost[end];
             ++end;
          }
          else {
             --start;
             sum += gas[start] - cost[start];
          }
       }
       return sum >= 0 ? start : -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas={2,3};
		int[] cost={3,1};
		GasStation tGasStation=new GasStation();
		System.out.println(tGasStation.canCompleteCircuit(gas, cost));
	}

}
