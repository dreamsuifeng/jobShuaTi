package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BrickWall554 {
	public int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map=new HashMap<>();
		for (int i=0;i<wall.size();++i){
			List<Integer> tmp=wall.get(i);
			int t=0;
			for(int j=0;j<tmp.size()-1;++j){
				t+=tmp.get(j);
				map.compute(t, (k,v)->v==null?1:v+1);
			}
		}
		int ans=0;
		Iterator<Map.Entry<Integer, Integer>> it=map.entrySet().iterator();
		while(it.hasNext()){
			ans=Math.max(ans, it.next().getValue());
		}
		return wall.size()-ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
