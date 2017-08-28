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
		long ans=0;
		for (int i=1;i<=1111;i++){
			ans=(ans+ans*i)%5;
		}
		System.out.println(ans);
	}
}
