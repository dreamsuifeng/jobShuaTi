package LeetCode;

public class RotateFunction396 {
	public int maxRotateFunction(int[] A) {
		if (A==null || A.length==0){
			return 0;
		}
		long res=0;
		int n=A.length;
		int k=0;
		long start=0;
		for (int i=0;i<n;++i){
			res+=k*A[i];
			start+=A[i];
            k++;
		}
        long tmp=res;
		for (int i=1;i<n;++i){
            tmp=tmp-start+n*A[i-1];
			res=Math.max(res, tmp);
		}
		return (int)res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
