package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BinaryWatch401 {
	List<String> res;
	int[] hour=new int[]{1,2,4,8};
	int[] min=new int[]{1,2,4,8,16,32};
	
	public void readHour(int n, List<String> h,int preH,Set<Integer> used){
		if (n==0) {
			h.add(String.valueOf(preH));
			return;
		}
		for (int i=0;i<hour.length;++i){
			if (!used.contains(i)){
				used.add(i);
				readHour(n-1, h, preH+hour[i],used);
				used.remove(i);
			}
			
		}
	}
	public void readMin(int n, List<String> m,int preM,Set<Integer> used){
		if (n==0) {
			m.add(String.valueOf(preM));
			return;
		}
		for (int i=0;i<min.length;++i){
			if (!used.contains(i)){
				used.add(i);
				readMin(n-1, m, preM+min[i],used);
				used.remove(i);
			}
			
		}
	}
	public List<String> readBinaryWatch(int num) {
		Set<String> reStrings=new HashSet<>();
		for (int i=0;i<=num;++i){
			List<String> hList=new ArrayList<>();
			readHour(i, hList, 0, new HashSet<Integer>());
			List<String> mList=new ArrayList<>();
			readMin(num-i, mList, 0, new HashSet<Integer>());
			for (int j=0;j<hList.size();++j){
				if (Integer.valueOf(hList.get(j))>=12)continue;
				for (int k=0;k<mList.size();++k){
					if (Integer.valueOf(mList.get(k))>=60) continue;
					String t=hList.get(j)+":";
					if (mList.get(k).length()<2){
						t+=("0"+mList.get(k));
					}else{
						t+=mList.get(k);
					}
					reStrings.add(t);
				}
			}
		}
		System.out.println(reStrings.size());
		res=new ArrayList<>(reStrings);
		Collections.sort(res,(x,y)->x.compareTo(y));
		return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryWatch401 t=new BinaryWatch401();
		System.out.println(t.readBinaryWatch(2));
		String[] out={"0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"};
		System.out.println(out.length);
	}

}
