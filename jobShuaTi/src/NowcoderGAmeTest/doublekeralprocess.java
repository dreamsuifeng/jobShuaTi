package NowcoderGAmeTest;


import java.util.*;

public class doublekeralprocess {
	public static int solve(int[] array,int sum,int n){
		
		int[][] f = new int[n + 1][sum / 2 + 1];  
        for (int i = 0; i < n; i++) {  
            for (int j = 1; j <= sum / 2; j++) {  
                f[i + 1][j] = f[i][j];  
                if (array[i] <= j && f[i][j - array[i]] + array[i] > f[i][j]) {  
                    f[i + 1][j] = f[i][j - array[i]] + array[i];  
                }  
            }  
        }
		return sum-f[n][sum/2];
	}
	public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] d=new int[n];
        int sum=0;
        for (int i=0;i<n;++i){
        	int t=in.nextInt()/1024;
        	sum+=t;
        	d[i]=t;
        }
        
        System.out.println(solve(d, sum, n)*1024);
        
        	
        
        
    }

}
