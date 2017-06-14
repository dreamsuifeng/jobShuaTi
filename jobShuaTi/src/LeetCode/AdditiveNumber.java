package LeetCode;
import java.math.BigInteger;
public class AdditiveNumber {
public boolean isTrue(String num,  BigInteger one, BigInteger two, int start){
		if (start == num.length()) return true;
        two=two.add(one);
        one=two.subtract(one);
        String string=two.toString();
        return num.startsWith(string,start) && isTrue(num, one, two, start+string.length());
    }
    public boolean isAdditiveNumber(String num) {
    	int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = i+1; j <= n - i; ++j) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isTrue(num,x1, x2, j + i)) return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber t=new AdditiveNumber();
		System.out.println(t.isAdditiveNumber("10111001111234122"));
	}

}
