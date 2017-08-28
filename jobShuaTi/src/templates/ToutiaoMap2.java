package templates;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ToutiaoMap2 {
	
	static class element{
		double wei;
		char c;
		boolean isFirst;
		public element(double weight,char c,boolean b){
			this.wei=weight;
			this.c=c;
			this.isFirst=b;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		double[] weights=new double[10];
		in.nextLine();
		HashSet<Integer> firstChar=new HashSet<>();
		List<char[]> inputs=new ArrayList<>();
		for (int i=0;i<n;++i){
			char[] tmp=in.nextLine().toCharArray();
			inputs.add(tmp);
			firstChar.add(tmp[0]-'A');
			for (int j=1;j<=tmp.length;++j){
				weights[tmp[tmp.length-j]-'A']+=Math.pow(10, j-1);
			}
		}
		element[] ele=new element[10];
		for (int i=0;i<weights.length;++i){
			if (firstChar.contains(i)){
				ele[i]=new element(weights[i], (char)(i+'A'), true);
			}else{
				ele[i]=new element(weights[i], (char)(i+'A'), false);
			}
		}
		Arrays.sort(ele,new Comparator<element>() {

			@Override
			public int compare(element o1, element o2) {
				// TODO Auto-generated method stub
				return (int) (o2.wei-o1.wei);
			}
		});
		
		HashMap<Character, Integer> maptoInt=new HashMap<>();
		for (int i=9;i>=0;--i){
			if (!ele[i].isFirst){
				maptoInt.put(ele[i].c, 0);
				break;
			}
		}
		int num=9;
		for (int i=0;i<=9;++i){
			if (!maptoInt.containsKey(ele[i].c)){
				maptoInt.put(ele[i].c, num);
				num--;
			}
		}
		long ans=0;
		for (int i=0;i<inputs.size();++i){
			char[] tmp=inputs.get(i);
			long r=0;
			for (char c:tmp){
				r=r*10+maptoInt.get(c);
			}
//			System.out.println(r);
			ans+=r;
		}
		System.out.println(ans);
	}

}
