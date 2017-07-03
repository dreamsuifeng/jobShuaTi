package LeetCode;

public class IsSubsequence392 {
	public static boolean isSubsequence(String s, String t) {
        int n=s.length();
        int i=0;
        int fromIndex=0;
        while (i<n){
        	int idx=t.indexOf(s.charAt(i),fromIndex);
        	if (idx==-1) return false;
        	fromIndex=idx+1;
        	i++;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSubsequence("abc", "adcbc"));
	}

}
