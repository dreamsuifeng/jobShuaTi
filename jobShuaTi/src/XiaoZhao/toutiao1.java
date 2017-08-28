package XiaoZhao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class toutiao1 {
	static class point{
		long x;
		long y;
		public point(long x,long y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int binsearch(point[] points,long y, int s,int e){
		
		int mid=s-()
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		point[] points1=new point[N];
		point maxpoints=new point(0, 0);
		long max=-1;
		
		for (int i=0;i<N;++i){
			long x=in.nextLong();
			long y=in.nextLong();
			points1[i]=new point(x, y);
			if (x>max){
				maxpoints=points1[i];
			}
			if (x==max){
				if (y<maxpoints.y){
					maxpoints=points1[i];
				}
			}
//			points2[i]=new point(x, y);
		}
		Arrays.sort(points1,new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return (int) (o1.y-o2.y);
			}
		});
		System.out.println(maxpoints.x+" "+maxpoints.y);
		if (index<0){
			
		}
		
	}

}
