package hihoCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;




public class kangtuo {
	
	static long kangtuo(char[] str){
		long[] f=new long[str.length];
		f[0]=1;
		for (int i=1;i<f.length;++i){
			f[i]=f[i-1]*i;
		}
		int len=str.length;
		long ans=0;
		for (int i=0;i<len;++i){
			int tmp=0;
			for (int j=i+1;j<len;++j){
				if (str[j]<str[i]) tmp++;
				
			}
			ans+=tmp*f[len-i-1];
		}
		return ans;
	}
	static void reverseKangtuo(long n,long m){
//		n--;
		long[] f=new long[(int) m];
		f[0]=1;
		for (int i=1;i<m;++i){
			f[i]=f[i-1]*i;
		}
		ArrayList<Integer> v=new ArrayList<>();
		ArrayList<Integer> a=new ArrayList<>();
		for (int i=1;i<=m;++i){
			v.add(i);
		}
		for (int i=(int) m;i>=1;--i){
			long r=n%f[i-1];
			long t=n/f[i-1];
			n=r;
			
//			Collections.sort(v);
			a.add(v.get((int) t));
			Integer a1=v.remove((int)t);
		}
		for (int i=0;i<a.size();++i){
			System.out.print(a.get(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseKangtuo(20, 4);
	}

}
