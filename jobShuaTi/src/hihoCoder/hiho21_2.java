package hihoCoder;

import java.util.Scanner;

public class hiho21_2 {

	static char[][]data;
	static int n,m;
	static int[][] face={{0,1},{1,0},{0,-1},{-1,0}};//r,d,l,u
	public static void main(String[]args){
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		in.nextLine();
		data=new char[2*n+1][2*m+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=m;j++)
				data[2*i][2*j]='+';
		char d='d';
		int x=1,y=1;
		for(int i=0;i<2*n*m-1;i++)
		{
			int[] temp=new int[3];
			temp[0]=in.nextInt();
			temp[1]=in.nextInt();
			temp[2]=in.nextInt();
			work(temp,d,x,y);
			d=in.nextLine().charAt(1);
			switch(d){
			case 'l':
				y=y-2;
				break;
			case 'r':
				y=y+2;
				break;
			case 'u':
				x=x-2;
				break;
			case 'd':
				x=x+2;
			}
		}
		print();
	}
	static int findFace(char c){
		switch(c){
		case 'r':
			return 0;
		case 'd':
			return 1;
		case 'l':
			return 2;
		case 'u':
			return 3;
		}
		return -1;
	}
	static void work(int[]f,char d,int x,int y){
	//	System.out.println(d);
		int index=findFace(d);
		for(int i=index-1;i<=index+1;i++){
			int tx=x+face[(i+4)%4][0];
			int ty=y+face[(i+4)%4][1];
			if(f[i-(index-1)]==1){
				if(tx%2==0)
					data[tx][ty]='-';
				else
					data[tx][ty]='|';
			}
			
		//	print();
		//	System.out.println();
		}
	}
	static void print(){
		for(int i=0;i<=2*n;i++)
		{
			for(int j=0;j<=2*m;j++)
				System.out.print(data[i][j]==0?" ":data[i][j]);
			System.out.println();
		}
				
	}
}