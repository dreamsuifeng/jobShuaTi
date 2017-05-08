package hihoCoder;
import java.util.Scanner;
public class BaiduT1 {
	static String YaSuo(String inputs){
		String result="";
		String[] inputToA=inputs.split(":");
		for (int i=0;i<inputToA.length;++i){
			int j=0;
			while(j<inputToA[i].length()){
				if (inputToA[i].charAt(j)=='0'){
					++j;
				}else{
					break;
				}
			}
			result+=inputToA[i].substring(j, inputToA[i].length());
			result+=":";
		}
		return result.substring(0, result.length()-1);
	}
	static String JieYaSuo(String inputs){
		String result="";
		String[] inputsToA=inputs.split(":",-1);
		for (int i=0;i<inputsToA.length;++i){
			if (inputsToA[i].length()==0){
				result+="000000";
			}else{
				for (int j=0;j<6-inputsToA[i].length();++j){
					result+="0";
				}
			}
			result+=inputsToA[i];
			result+=":";
		}
		return result.substring(0, result.length()-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int flage=in.nextInt();
			String input=in.next();
			if (flage==0){
				System.out.println(YaSuo(input));
			}else{
				System.out.println(JieYaSuo(input));
			}
}
	}
}
