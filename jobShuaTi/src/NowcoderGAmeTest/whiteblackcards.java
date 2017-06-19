package NowcoderGAmeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class whiteblackcards {
	public static int solve(String s){
		Map<Character, Character> map=new HashMap<>();
		map.put('W', 'B');
		map.put('B', 'W');
		char[] cs=s.toCharArray();
		int n=cs.length;
		int maxlen=0;
		int index=-1;
		for(int i=0;i<n;++i){
			int tmllen=1;
			for (int j=i+1;j<n;++j){
				if (cs[j]!=cs[j-1]){
					tmllen++;
				}else{
					break;
				}
			}
			if(tmllen>maxlen){
				maxlen=tmllen;
				index=i;
			}
		}
//		System.out.println(maxlen+","+index);
		int res=0;
		for (int j=index-1;j>=0;--j){
			if (cs[j]==cs[j+1]){
				res++;
				cs[j]=map.get(cs[j]);
			}
		}
		for (int i=index+maxlen;i<n;++i){
			if (cs[i]==cs[i-1]){
				res++;
				cs[i]=map.get(cs[i]);
			}
		}
		return res;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s=in.next();
		System.out.println(solve(s));
	}
}
