package XiaoZhao;

import java.util.Scanner;

public class toutiao2 {
	public static long solve(int[] d, int[] preSum){
		long ans=0;
		for (int i=0;i<d.length;++i){
			int min=d[i];
			for (int j=i;j>=0;--j){
				int tmpSum;
				
				if (j==0){
					tmpSum=preSum[i];
				}else{
					tmpSum=preSum[i]-preSum[j-1];
				}
				min=Math.min(d[j], min);
				ans=Math.max(tmpSum*min, ans);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] d=new int[n];
		int[] preMin=new int[n];
		int[] preSum=new int[n];
		int sum=0;
		for (int i=0;i<n;++i){
			
			d[i]=in.nextInt();
			sum+=d[i];
			preSum[i]=sum;
			if (i==0) {
				preMin[i]=d[i];
			}else{
				preMin[i]=Math.min(d[i],preMin[i-1]);
			}
		}
		System.out.println(solve(d, preSum));
		
		
	}

}
