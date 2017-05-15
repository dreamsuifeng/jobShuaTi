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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(100));
//		System.out.println((char)(26+64));
	}

}
