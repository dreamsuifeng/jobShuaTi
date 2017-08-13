package XiaoZhao;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Wangyi_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] array=new int[n];
		for (int i=0;i<n;++i){
			array[i]=in.nextInt();
		}
		Arrays.sort(array);
		if (n<=2){
			System.out.println("Possible");
			return;
		}else{
			int d=array[1]-array[0];
			for (int i=2;i<n;++i){
				if (array[i]-array[i-1]!=d){
					System.out.println("Impossible");
					return;
				}
			}
			System.out.println("Possible");
		}
	}
	
public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index=Collections.binarySearch(arr, x);
        int idi=index;
        if (index<0){
        	idi=-(index+1);
        }
        int len=arr.size();
        List<Integer> res=new LinkedList<>();
        int[][] idff=new int[len][2];
        for (int i=0;i<len;++i){
        	idff[i][0]=Math.abs(arr.get(i)-x);
        	idff[i][1]=i;
        }
        Arrays.sort(idff,(xx,y)->(xx[0]!=y[0]) ? xx[0]-y[0]:xx[1]-y[1]);
        for (int i=0;i<k;i++){
        	res.add(idff[i][1]);
        }
        return res;
        
    }

}
