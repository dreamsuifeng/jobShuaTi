package LeetCode;

public class SuperWashingMachines517 {
	public int findMinMoves(int[] machines) {
		int total = 0; 
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines) max = Math.max(Math.max(max, Math.abs(cnt+=load-avg)), load-avg);
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
