package LeetCode;

public class BeautifulArrangementII667 {
	public int[] constructArray(int n, int k) {
        int[] ans=new int[n];
        int l=1, r=n;
        for (int i=0;i<n;++i){
        	if(k%2==0){
        		ans[i]=l++;
        	}else{
        		ans[i]=r--;
        	}
        	if (k>1) k--;
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
