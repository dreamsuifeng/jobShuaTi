package hihoCoder;

public class LongestSubStr {
	
	public static void main(String[] args){
		String s1="SititoutG";
				
		String s2="Sitdownandshutup";
		LongestSubStr obj=new LongestSubStr();
		System.out.println(obj.LongestSub(s1,s2));
	}
	int  LongestSub(String str1,String str2){
        int len1 = str1.length();  
        int len2 = str2.length();  
        String min = null;  
        String max = null;  
        String target = null;
//        int max_value=0;
        min = len1 <= len2 ? str1 : str2;
        max = len1 >  len2 ? str1 : str2;
        for (int i = min.length(); i >= 1; i--) {
            for (int j = 0; j <= min.length() - i; j++) {  
                target = min.substring(j, j + i);
//                System.out.println(target);
               for (int k = 0; k <= max.length() - i; k++) {  
                  if (max.substring(k,k + i).equals(target)){ 
                	  return i;
                    }
                }
            }
        }  
        return 0;  
}
}
