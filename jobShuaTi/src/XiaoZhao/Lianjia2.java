package XiaoZhao;
import java.util.*;
public class Lianjia2 {
	static class course{
		long a;
		long b;
		public course(long a,long b){
			this.a=a;
			this.b=b;
		}
	}
	public static long solve(course[] data,long n,long allGrade,long curSum,long r){
		Arrays.sort(data,new Comparator<course>() {

			@Override
			public int compare(course o1, course o2) {
				// TODO Auto-generated method stub
				return (int) (o1.b-o2.b);
			}
		});
		long ans=0;
		long diff=allGrade-curSum;
		int i=0;
		while (diff!=0 && i<n){
			course tmp=data[i];
			if (tmp.a<r){
				long gradeDiff=r-tmp.a;
				if (gradeDiff>diff){
					gradeDiff=diff;
				}
				ans+=(gradeDiff*tmp.b);
				diff-=gradeDiff;
			}
			i++;
		}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long n=in.nextLong();
		long r=in.nextLong();
		long avg=in.nextLong();
		course[] data=new course[(int) n];
		long sumGrade=0;
		for (int i=0;i<n;++i){
			long ai=in.nextLong();
			long bi=in.nextLong();
			sumGrade+=ai;
			data[i]=new course(ai, bi);
		}
		System.out.println(solve(data, n, avg*n, sumGrade, r));
	}

}
