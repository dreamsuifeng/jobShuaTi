package LeetCode;

public class FindtheDifference389 {
	public char findTheDifference(String s, String t) {
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        int[] d=new int[26];
        for (int i=0;i<s1.length;++i){
        	d[s1[i]-'a']++;
        }
        for (int j=0;j<t1.length;++j){
        	if (--d[t1[j]]<0) return t1[j];
        
        }
        return t1[t1.length-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
