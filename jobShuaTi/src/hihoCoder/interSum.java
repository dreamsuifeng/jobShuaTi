package hihoCoder;

import java.util.Scanner;

public class interSum {
	long mod=(long) (10e9+7);
	static class node{
		long s,n;
		public node(){};
	}
	node[][][] dp=new node[21][20][400];
	int[] bits=new int[21];
	long[] base=new long[21];
	
	public node dfs(int len, int dig,boolean begin_zero,boolean end_flag, int sum){
		node t=new node();
		t.s=0;
		t.n=0;
		if (len<=0 || len>=20 || dig<0 || dig>9 || sum<-200 || sum>=200) return t;
		if (!end_flag && dp[len][dig+(begin_zero?0:10)][sum+200].n!=-1){
			return dp[len][dig+(begin_zero?0:10)][sum+200];
		}
		if (len==1){
			if (dig!=sum){
				return t;
			}
			t.n=1;
			t.s=sum;
			return t;
		}
		int end=end_flag?bits[len-2]:9;
		int newsum=dig-sum;
		node tmp;
		for (int j=0;j<end+1;++j){
			if (!begin_zero){
				tmp=dfs(len-1,j, j!=0, end_flag&&(j==end), sum);
			}else{
				tmp=dfs(len-1, j, true, end_flag&&(j==end), newsum);
			}
			t.n+=tmp.n;
			t.s=((t.s+tmp.s)%mod+((tmp.n*dig)%mod*base[len-1])%mod)%mod;
		}
		if (!end_flag) dp[len][dig+(begin_zero?0:10)][sum+200]=t;
		return t;
		
	}
	int solve(long n,int s){
		if (n<=0) return 0;
		int l=0;
		while (n>0){
			bits[l++]=(int) (n%10);
			n/=10;
		}
		return (int) dfs(l+1, 0, false, true, s).s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long l=in.nextLong();
		long r=in.nextLong();
		int k=in.nextInt();
		interSum itSum=new interSum();
		node t=new node();
		t.n=-1;
		t.s=0;
		for(int i=0;i<21;++i){
			for (int j=0;j<20;++j){
				for (int l1=0;l1<400;++l1)
				itSum.dp[i][j][l1]=t;
			}
		}
		itSum.base[0]=1;
		for (int i=1;i<21;++i){
			itSum.base[i]=(itSum.base[i-1]*10)%itSum.mod;
		}
		System.out.println((itSum.solve(r, k)-itSum.solve(l-1, k)+itSum.mod)%itSum.mod);
	}

}
