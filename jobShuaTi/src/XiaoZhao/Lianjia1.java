package XiaoZhao;

import java.util.*;
public class Lianjia1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		List<Integer> res=new ArrayList<>();
		HashSet<Integer> set=new HashSet<>();
		for (int i=0;i<n;++i){
			int d=in.nextInt();
			if (!set.contains(d)){
				res.add(d);
				set.add(d);
			}
		}
		Collections.sort(res);
		System.out.println(res.size());
		for (int i=0;i<res.size();++i){
			System.out.print(res.get(i));
			if (i<res.size()-1){
				System.out.print(" ");
			}
		}
		System.out.println();
		
	}

}
