package LeetCode;

import java.util.List;

public class ReplaceWords648 {
	public static String replaceWords(List<String> dict, String sentence) {
		String[] words=sentence.split(" ");
		int l=dict.size();
		int n=words.length;
		StringBuffer sBuffer=new StringBuffer();
		for (String w:words){
			boolean falg=false;
			for (String d:dict){
				if (w.startsWith(d)){
					sBuffer.append(d);
					sBuffer.append(" ");
					falg=true;
					break;
				}
				
				}
			if (!falg) sBuffer.append(w);
			}
		
		return sBuffer.toString().substring(0,sBuffer.length()-1);
    }
	public static void main(String[] args){
//		System.out.println(replaceWords(dict, sentence));
	}
}
