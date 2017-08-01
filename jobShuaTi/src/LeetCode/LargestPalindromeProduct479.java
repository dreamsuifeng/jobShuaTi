package LeetCode;

public class LargestPalindromeProduct479 {
	public long create(long num){
		String string=num+new StringBuffer().append(num).reverse().toString();
		return Long.parseLong(string);
	}
	public int largestPalindrome(int n) {
        int mod=1337;
        long Upbound=(long) (Math.pow(10, n)-1);
        long downBound=Upbound/10;
        long maxNUmber=Upbound*Upbound;
        long preHalf=(long) (maxNUmber/Math.pow(10, n));
        boolean found=false;
        long res=0;
        while (!found){
        	res=create(preHalf);
        	for (long i=Upbound;i>=downBound;--i){
        		if (res%i==0 && res/i>=downBound && res/i<=Upbound){
        			found=true;
        			break;
        		}
        	}
        }
        return (int)res;
    }
}
