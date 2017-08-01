package LeetCode;

public class LicenseKeyFormatting482 {
	public static String licenseKeyFormatting(String S, int K) {
        StringBuffer sb=new StringBuffer();
        sb.append(S);
        sb.reverse();
        String Rs=sb.toString();
        StringBuffer res=new StringBuffer();
        int count=0;
        for (char c:Rs.toCharArray()){
        	if (count==K && c!='-'){
        		res.insert(0, '-');
        		count=0;
        	}
        	if (c!='-'){
        	res.insert(0, Character.toUpperCase(c));
        	count++;
        	}
        	
        }
        return res.toString();
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(licenseKeyFormatting("2-4A0r7-4k", 3));
	}

}
