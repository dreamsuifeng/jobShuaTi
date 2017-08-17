package LeetCode;

public class StudentAttendanceRecord2_552 {
	static final int M = 1000000007;
	public static int checkRecord(int n) {
//		final int M = 1000000007;
		long[] endPL=new long[n+1];
		long[] endP=new long[n+1];
		endPL[0]=1;
		endP[0]=1;
		endPL[1]=2;
		endP[1]=1;
		for (int i=2;i<=n;++i){
			endP[i]=endPL[i-1];
			endPL[i]=(endP[i]+endP[i-1]+endP[i-2])%M;
		}
		long res=endPL[n];
		System.out.println(res);
		for (int i=0;i<n;++i){
			long s=(endPL[i]*endPL[n-i-1])%M;
			res=(res+s)%M;
		}
		return (int) res;
    }
	
	
	public static int checkRecord1(int n) {
	    long[] PorL = new long[n + 1]; // ending with P or L, no A
	    long[] P = new long[n + 1]; // ending with P, no A
	    PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

	    for (int i = 2; i <= n; i++) {
	        P[i] = PorL[i - 1];
	        PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
	    }
	    
	    long res = PorL[n];
	    System.out.println(res);
	    for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
	    	long s = (PorL[i] * PorL[n - i - 1]) % M;
	        res = (res + s) % M;
	    }
	    
	    return (int) res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkRecord(2));
	}

}
