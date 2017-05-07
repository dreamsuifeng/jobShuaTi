package LeetCode;

//import java.util.Stack;

public class InterleavingString {
//public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length()+s2.length()!=s3.length()){
//        	return false;
//        }
//        if (s1.length()==0 && s2.length()>0){
//        	if (s2.equals(s3)){
//        		return true;
//        	}else{
//        		return false;
//        	}
//        }else if (s1.length()>0 && s2.length()==0){
//        	if (s1.equals(s3)){
//        		return true;
//        	}else{
//        		return false;
//        	}
//        }else{
//	        if (s3.charAt(0)==s1.charAt(0) && s3.charAt(0)!=s2.charAt(0)){
//	        	return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()));
//	        }else if(s3.charAt(0)!=s1.charAt(0) && s3.charAt(0)==s2.charAt(0)){
//	        	return isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
//	        }else if(s3.charAt(0)==s1.charAt(0) && s3.charAt(0)==s2.charAt(0)){
//	        	return isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length())) || isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()));
//	        }else{
//	        	return false;
//	        }
//        }
//}
	public boolean isInterleave(String s1, String s2, String s3) {

	    if ((s1.length()+s2.length())!=s3.length()) return false;

	    boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

	    matrix[0][0] = true;

	    for (int i = 1; i < matrix[0].length; i++){
	        matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
	    }

	    for (int i = 1; i < matrix.length; i++){
	        matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
	    }

	    for (int i = 1; i < matrix.length; i++){
	        for (int j = 1; j < matrix[0].length; j++){
	            matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
	                    || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
	        }
	    }

	    return matrix[s2.length()][s1.length()];

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString test=new InterleavingString();
		String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		String s4 ="aadbbbaccc";
		System.out.println(test.isInterleave(s1, s2, s3));
	}

}
