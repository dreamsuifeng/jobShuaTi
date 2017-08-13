package NowcoderGAmeTest;

import java.util.Scanner;

public class worksArrange {
	private static int ans=0;
	public static void dfs(int wi,boolean[] used, int[][] workes,int n){
		if (wi==n) {
			ans++;
			return;
		}
		for (int i=0;i<6;i++){
			if (!used[i] && workes[wi][i]==1){
				used[i]=true;
				dfs(wi+1, used, workes, n);
				used[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] workes=new int[n][6];
		in.nextLine();
		for (int i=0;i<n;++i){
			char[] cs=in.nextLine().toCharArray();
			for (char c:cs){
				if (c=='0'){
					workes[i][0]=1;
				}else if (c=='1'){
					workes[i][1]=1;
				}else if (c=='2'){
					workes[i][2]=1;
				}else if (c=='3'){
					 workes[i][3]=1;
				}else if (c=='4'){
					workes[i][4]=1;
				}else{
					workes[i][5]=1;
				}
				
			}
		}
		dfs(0, new boolean[6], workes, n);
		System.out.println(ans);
	}

}
