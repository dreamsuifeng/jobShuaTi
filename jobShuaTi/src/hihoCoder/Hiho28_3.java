package hihoCoder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Hiho28_3 {

	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][]polys=new int[n][4];
		for(int i=0;i<n;i++)
		{
			in.nextLine();
			polys[i][0]=in.nextInt();
			polys[i][1]=in.nextInt();
			polys[i][2]=in.nextInt();
			polys[i][3]=in.nextInt();
		}
		work(polys,n);
		
	}
	public static void work(int[][]polys,int n){
		HashSet<String>set=new HashSet<String>();
		for(int i=0;i<n;i++)
		{
			putpoint(set,polys[i][0],polys[i][1]);
			putpoint(set,polys[i][2],polys[i][3]);
			putpoint(set,polys[i][0],polys[i][3]);
			putpoint(set,polys[i][2],polys[i][1]);
		}
		int minx=Integer.MAX_VALUE,miny=Integer.MAX_VALUE;
		int maxx=-1,maxy=-1;
		Iterator<String>p=set.iterator();
		while(p.hasNext())
		{
			String[] s=p.next().split(",");
			
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			System.out.println(x+","+y);
			if(x<minx)
				minx=x;
			if(y<miny)
				miny=y;
			if(x>maxx)
				maxx=x;
			if(y>maxy)
				maxy=y;
		}
		System.out.println(minx+" "+miny+" "+maxx+" "+maxy);
	}
	public static void putpoint(HashSet<String>set,int x,int y){
		String s=x+","+y;
		if(set.contains(s))
			set.remove(s);
		else
			set.add(s);
	}
}
