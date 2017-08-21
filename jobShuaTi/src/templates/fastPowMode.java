package templates;

public class fastPowMode {
	public static int fastPow(int n,int mod,int k){
		int r=1;
		while (k>0){
			if ((k&1)==1) r=(r*n)%mod;
			n=(n*n)%mod;
			k>>=1;
		}
		return r;
	}
	public static void main(String[] args){
		System.out.println(fastPow(5, 10, 4));
		System.out.println(Math.pow(5, 4));
	}
}
