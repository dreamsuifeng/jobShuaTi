package otherAlgorithsTest;

import java.util.ArrayList;
import java.util.Arrays;

public class pinduduTest1 {
	public static double solve(double[][] data) {
		Arrays.sort(data, (x,
				y) -> (x[1] != y[1] ? new Double(x[0]).compareTo(new Double(y[0])) : new Double(x[1]).compareTo(y[1])));
		double res = 0.0;
		double start = data[0][0];
		double end = data[0][1];
		for (int i = 1; i < data.length; ++i) {
			if (data[i][0]>end){
				res+=(end-start);
				start=data[i][0];
				end=data[i][1];
			}else if (data[i][0]<start){
				start=data[i][0];
				end=data[i][1];
			}else{
				end=data[i][1];
			}
		}
		res+=(end-start);
		return res;

	}
	public static int[][] solve3(int n){
		int[][] res=new int[n][n];
		int k=1;
		for (int i=0;i<=n/2;++i){
			for (int j=i;j<n-i;++j){
				res[i][j]=k++;
			}
			for (int j=i+1;j<n-i;++j){
				res[j][n-i-1]=k++;
			}
			for(int j = n-i-2;j>=i;j--){   
                res[n-i-1][j] = k++;                          //下方行方向  
            }  
            for(int j = n-i-2;j>i;j--){  
                res[j][i] = k++;          
            }  
		}
		for (int[] i:res){
			for (int j:i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		return res;
	}
	public int solve4(int[] data){
		for (int i=1;i<data.length-1;++i){
			if (data[i]<=data[i-1] && data[i]<=data[i+1]){
				return i;
			}
		}
		return -1;
	}
	
	public class pin5{
		private int multi=0;
		private int help(int a1,int b1){
			int res=0;
			int mul=0;
			while (a1<b1){
				if (b1>a1*2 && b1!=2*(a1+1)){
					a1*=2;
					multi++;
				}else{
					a1+=1;
					res++;
				}
			}
			multi=Math.max(multi, mul);
			return res;
		}
		public int solve5(int[] a,int[] b){
			int res=0;
			for (int i=0;i<a.length;++i){
				if (a[i]>b[i]) {
					System.out.println(-1);
					return -1;
				}else{
					res+=help(a[i], b[i]);
				}
				
			}
			res+=multi;
			System.out.println(res);
			return res;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve3(4));
	}

}
