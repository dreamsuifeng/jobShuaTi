package LeetCode;

public class SuperPow372 {
	final int  mod=1337;
	public int superPow(int a, int[] b) {
		if (b==null || b.length==0) return 1;
		return superPow(a, b,b.length);
		
	}
	private int superPow(int a, int[] b, int length) {
        if (length == 1) {
            return powd(a, b[0]);
        }
        
        return powd(superPow(a, b, length - 1), 10) * powd(a, b[length - 1]) % mod;
    }
	public int powd(int a, int k){
		a%=mod;
		int res=1;
		for (int i=0;i<k;++i){
			res=(res*a)%mod;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
	