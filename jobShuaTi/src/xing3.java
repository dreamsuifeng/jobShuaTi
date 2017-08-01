import java.util.Scanner;

public class xing3 {
	static int maxdese(int[] d,int start){
		int n=d.length;
		int[] dp=new int[n-start];
		for (int i=start;i<n;++i){
			int t=0;
			for (int j=start;j<i;++j){
				if (d[i]<d[j]){
					t=Math.max(t, dp[j]);
				}
			}
			dp[i-start]=t+1;
		}
		return dp.length-dp[n-start-1];
	}
	static int solve(int[] d,int n,int maxvalue,int index){
		int post=maxdese(d, index+1);
		int pre=index;
		if (index==0) return post;
		int first=d[0];
		boolean flagfirestmax=true;
		for (int i=1;i<index;++i){
			if (d[i]>first){
				flagfirestmax=false;
				break;
			}
			
		}
		return flagfirestmax ? post+pre-1:post+pre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] d=new int[n];
		int maxindex=-1;
		int maxvalue=Integer.MIN_VALUE;
		for (int i=0;i<n;++i){
			d[i]=in.nextInt();
			if (d[i]>maxvalue){
				maxindex=i;
				maxvalue=d[i];
			}
		}
		System.out.println(solve(d, n, maxvalue, maxindex));
		
	}

}
