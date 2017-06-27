package otherAlgorithsTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CodeMB1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] parent=new int[n+1];
		for (int i=2;i<=n;++i){
			parent[i]=in.nextInt();
		}
		int[] val=new int[n+1];
		for ( int i=1;i<=n;++i){
			val[i]=in.nextInt();
		}
		int[][] h=new int[n+1][3];
		h[1][0]=1;
		h[1][1]=1;
//		System.out.println("data input end");
		int[] color=new int[n+1];
		for (int i=2;i<=n;++i){
			int htmp=1;
			int t=i;
			while(t!=0){
				t=parent[t];
				htmp++;
			}
			h[i][0]=htmp;
			h[i][1]=i;
			h[i][2]=val[i];
		}
		Arrays.sort(h,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0]!=o2[0]) return o2[0]-o1[0];
				else  return o2[2]-o1[2];
			}
		});
		int res=0;
		for (int i=1;i<=n;++i){
			if (color[i]==1) continue;
			res++;
			int v=h[i][2];
			int t=h[i][1];
			int j=0;
			while(j<v){
				color[t]=1;
				t=parent[t];
				j++;
						
			}
		}
		System.out.println(res);
		
		
	}

}
