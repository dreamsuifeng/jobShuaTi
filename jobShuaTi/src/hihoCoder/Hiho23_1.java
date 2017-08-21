package hihoCoder;

import java.util.Scanner;

public class Hiho23_1 {
	static int ans=0;
	public static void print(int n,int k,int i,String cur,int pre){
		if (i>=n+1){
			ans++;
			return;
		}
		if (i==1){
			for (int j=1;j<=k;++j){
				
				if(j*pre<=k){
					cur+=j;
					print(n, k, i+1, cur,j);
					cur=cur.substring(0,cur.length()-1);
				
				}
			}
		}else{
			for (int j=0;j<=k;++j){

				if(j*pre<=k){
					cur+=j;
					print(n, k, i+1, cur,j);
					cur=cur.substring(0,cur.length()-1);
				
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		
			int N=in.nextInt();
			int K=in.nextInt();
			print(N, K, 1, "",1);
			System.out.println(ans);
		
	}

}
