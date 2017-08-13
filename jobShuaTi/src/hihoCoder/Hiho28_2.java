package hihoCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;

public class Hiho28_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		long ans=0;
		HashSet<String> set=new HashSet<>();
		for (int i=0;i<N;++i){
			String[] s = in.readLine().trim().split("/");
//			System.out.println(s.length);
			if (s.length<=1) continue;
			String tmp="";
			for (int j=0;j<s.length-1;++j){
				tmp+=s[j];
				if (!set.contains(tmp)){
					ans++;
					set.add(tmp);
				}
			}
		}
		System.out.println(ans-1);
	}

}

