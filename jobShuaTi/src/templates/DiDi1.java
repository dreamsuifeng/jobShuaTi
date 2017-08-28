package templates;


import java.util.*;
public class DiDi1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> data=new ArrayList<>();
		while(in.hasNext()){
			data.add(in.nextInt());
		}
		int ans=Integer.MIN_VALUE;
		int sum=0;
		for (int i:data){
			sum+=i;
			ans=Math.max(ans, sum);
			if (sum<0){
				sum=0;
			}
		}
		System.out.println(ans);
	}

}
