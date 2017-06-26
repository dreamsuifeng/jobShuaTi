package LeetCode;

public class SumofTwoIntegers371 {
	public int getSum(int a, int b) {
        return b==0 ? a:getSum(a^b, a&b);
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1<<2);
	}	

}
