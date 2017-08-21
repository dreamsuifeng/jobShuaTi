package hihoCoder;

import java.util.*;
public class hiho164 {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
	
		for (int i=0;i<T;++i){
			char[] line=in.next().toCharArray();
			int[][] pre=new int[line.length][2];
			int[][] post=new int[line.length][2];
			int zeroCount=0;
			int oneCount=0;
			for (int j=0;j<line.length;++j){
				pre[j][0]=zeroCount;
				pre[j][1]=oneCount;
				if (line[j]=='0') zeroCount++;
				else oneCount++;
			}
			zeroCount=0;
			oneCount=0;
			for (int j=line.length-1;j>=0;--j){
				post[j][0]=zeroCount;
				post[j][1]=oneCount;
				if (line[j]=='0') zeroCount++;
				else oneCount++;
			}
			int ans=Integer.MAX_VALUE;
			for (int j=0;j<line.length;++j){
				int t=pre[j][1]+post[j][0];
				ans=Math.min(ans, t);
			}
			System.out.println(ans);
		}
	}
}
