package NowcoderGAmeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class CodeA5 {
	public static int maxCommonDivisor2(int m, int n) {  
		if(m==1||n==1) return 1; 
		while (m % n != 0) {   
            int temp = m % n;   
            m = n;   
            n = temp;   
        }   
        return n;
    }
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        int l = 0;
        int r = 0;
        int k = 0;
        int[] nums = new int[n+1];
        for(int i=0; i<m; i++){
            l = sc.nextInt();
            r = sc.nextInt();
            k = sc.nextInt();
            for(int j=0; j<=n; j++)
                nums[j] = 0;
            for(int j=l-1; j<=r-1; j++){
                nums[a[j]]++;
            }
            int count = 0;
            for(int j=0; j<=n; j++){
                if(nums[j]!=0 && maxCommonDivisor2(nums[j],k)==1)
                    count++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}
