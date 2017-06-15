package LeetCode;
import java.util.List;
import java.util.ArrayList;
public class CountingBits338 {
	public int[] countBits(int num) {
        int[] res=new int[num+1];
        for (int i=0;i<=num;++i){
        	int t=i;
        	while(t!=0){
        		res[i]++;
        		t&=(t-1);
        	}
        }
        return res;
    }
	public int[] countBits1(int num) {
	    int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
	    return f;
	}
	public int[] countBits3(int num) {
	    int[] f = new int[num + 1];
	    for (int i=1; i<=num; i++) f[i] = f[i&(i-1)]+1;
	    return f;
	}
	public static void main(String[] args) {
		Integer i=1;
		// TODO Auto-generated method stub
		System.out.println(16 & 0x55555555);	

}
}
