package XiaoZhao;

import java.util.*;

public class Lianjia3 {
	
	private static boolean isTrue(int[] verify,int[] data, int n){
		for (int i=0;i<n;++i){
			if (verify[i]!=data[i]){
				return false;
			}
		}
		return true;
	}
	
	public static int sortThreeColor(int[] A, int n) {  
        // write code here  
		int ans=0;
        int left = 0;  
        int right = n-1;  
        int i = 0;  
        while(i <= right){  
            if(A[i] == 0){  
                swap(A,i,left++);  
                ans++;
                i++;  
            }else if(A[i] == 2){  
                swap(A,i,right--);  
                ans++;
            }else  
                i++;  
        }  
        return ans;  
    }  
    private static void swap(int[] A,int a,int b){  
        if(a != b){  
            int temp = A[a];  
            A[a] = A[b];  
            A[b] = temp;  
        }   
    }  
	private static void swap(int i,int j,int[] data){
		int t=data[i];
		data[i]=data[j];
		data[j]=t;
	}
	private static int ans=Integer.MAX_VALUE;
	public static void solve(int index,int[] verify,int[] data,int n,int cur){
		if (isTrue(verify, data, n)){
			ans=Math.min(ans, cur);
			return;
		}
		if (verify[index]==data[index]){
			solve(index+1, verify, data, n, cur);
			return;
		}
			
			
		int id=-1;
		for (int j=index+1;j<n;++j){
			if(data[j]==verify[index] && verify[j]==data[index]){
				id=j;
				break;
			}
		}
		if(id!=-1){
			swap(index, id, data);	
			solve(index+1, verify, data, n, cur+1);
		}
		if (id==-1){
			for (int j=index+1;j<n;++j){
				if(data[j]==verify[index] && verify[j]!=data[j]){
					id=j;
					swap(index, j, data);	
					solve(index+1, verify, data,  n, cur+1);
					swap(index, j, data);	
				}
			}
		}
			
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] data=new int[n];
		
		int oneCount=0;
		int twoCount=0;
		int threeCount=0;
		for (int i=0;i<n;++i){
			data[i]=in.nextInt();
			if (data[i]==1){
				oneCount++;
			}else if (data[i]==2){
				twoCount++;
			}else{
				threeCount++;
			}
		}
		int[] verify=new int[n];
		int i=0;
		for (int j=0;j<oneCount;++j){
			verify[i++]=1;
		}
		for (int j=0;j<twoCount;++j){
			verify[i++]=2;
		}
		for (int j=0;j<threeCount;++j){
			verify[i++]=3;
		}
		solve(0,verify, data, n, 0);
		System.out.println(ans);
		in.close();
	}

}

