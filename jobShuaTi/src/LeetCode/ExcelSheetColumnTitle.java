package LeetCode;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        String res="";
        while (n!=0){
            int t=n%26;
            if (t!=0){
            	res=(char)(t+64)+res;
            	n=n/26;
            }else{
            	res="Z"+res;
            	n=n/26-1;
            }
        }
        return res;
    }
	public static int titleToNumber(String s) {
        int res=0;
        int n=s.length();
        int step=1;
        for (int i=n-1;i>=0;--i){
        	res+=((int)s.charAt(i)-64)*step;
        	step*=26;
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(titleToNumber("AAAA"));
		
	}

}
