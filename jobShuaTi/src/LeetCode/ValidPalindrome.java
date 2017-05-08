package LeetCode;

import java.util.HashSet;
import java.util.regex.Pattern;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		Pattern pattern = Pattern.compile("([0-9]|[a-z])");
		s=s.toLowerCase();
        if (s.isEmpty()) return true;
        int i=0,j=s.length()-1;
        while(i<j){
//        	System.out.println(s.charAt(i)+","+pattern.matcher(""+s.charAt(i)).matches());
        	while (pattern.matcher(""+s.charAt(i)).matches()==false) i++;
        	while (pattern.matcher(""+s.charAt(j)).matches()==false) j--;
//        	System.out.println(i+","+j); 
        	if (s.charAt(i)==s.charAt(j)){
//        		System.out.println(i+","+j); 
        		i++;
        		j--;
        	}else return false;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome tes=new ValidPalindrome();
		String s1="A man, a plan, a canal: Panama";
		System.out.println(tes.isPalindrome(s1));
		HashSet<String> te=new HashSet<>();
		te.add("1");
		te.add("2");
		System.out.println(te.toString());
		te.remove("1");
		System.out.println(te.toString());
//		System.out.println("Ab : cd".toLowerCase());
//		Pattern pattern = Pattern.compile("([0-9]|[a-z])");
//	    System.out.print(pattern.matcher(",").matches());   
	}

}
