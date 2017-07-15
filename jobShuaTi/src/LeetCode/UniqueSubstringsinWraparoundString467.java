package LeetCode;

public class UniqueSubstringsinWraparoundString467 {
	public int findSubstringInWraproundString(String p) {
        int[] dp=new int[26];
        char[] ps=p.toCharArray();
        int maxlen=0;
        for (int i=0;i<ps.length;++i){
        	if (i>0 && (ps[i]==ps[i-1]+1 || ps[i]-'a'==ps[i-1]-'a'-25 )){
        		maxlen++;
        	}else{
        		maxlen=1;
        	}
        	dp[ps[i]-'a']=Math.max(dp[ps[i]-'a'], maxlen);
        	
        }
        int sum=0;
        for (int i:dp){
        	sum+=i;
        }
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
