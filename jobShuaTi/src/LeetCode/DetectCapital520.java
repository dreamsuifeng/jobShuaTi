package LeetCode;

public class DetectCapital520 {

	public boolean detectCapitalUse(String word) {
		int n=word.length();
        int Ucount=0;
        int Lcount=0;
        for(char c:word.toCharArray()){
        	if(Character.isUpperCase(c)) Ucount++;
        	else Lcount++;
        }
        if (Ucount==n || Lcount==n || (Ucount==1 && Character.isUpperCase(word.charAt(0)))) return true;
        else return false;
    }
}
