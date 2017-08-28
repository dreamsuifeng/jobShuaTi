package templates;

import java.util.Scanner;

public class MagicWeight {
	private static int res=0;
	private static boolean[] used;
	private static String[] inputs;
	public static boolean weight(String s,int k){
		int ans=0;
		for (int i=1;i<=s.length();++i){
			StringBuilder sBuilder=new StringBuilder();
			for (int j=i;j<s.length();++j){
				sBuilder.append(s.charAt(j));
			}
			for (int j=0;j<i;++j){
				sBuilder.append(s.charAt(j));
			}
			if (sBuilder.toString().equals(s)){
				ans++;
			}
		}
		return ans==k;
	}
	public static void dfs(int n,StringBuilder sb,int k){
		if (n<=0){
			if (weight(sb.toString(), k)){
				res++;
			}
			return;
		}
		for (int i=0;i<inputs.length;++i){
			if (!used[i]){
				used[i]=true;
				sb.append(inputs[i]);
				dfs(n-1, sb,k);
				sb.delete(sb.length()-inputs[i].length(), sb.length());
				used[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		inputs=new String[n];
		in.nextLine();
		for (int i=0;i<n;++i){
			inputs[i]=in.nextLine();
		}
		used=new boolean[n];
		dfs(n, new StringBuilder(), k);
		System.out.println(res);
	}

}
