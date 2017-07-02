package LeetCode;

public class SumofSquareNumbers633 {
	public static boolean judgeSquareSum(int c) {
		if (c==1 || c==0) return true;
		int i=0;
		int j=(int) Math.sqrt(c);
		while (i<=j){
			if (i*i+j*j==c) return true;
			else if (i*i+j*j<c) i+=1;
			else j-=1;
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(judgeSquareSum(2^31));
	}

}
