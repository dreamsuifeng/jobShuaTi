package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class BeautifulArrangement526 {
	private int res=0;
	private void dfs(int s, int N,HashSet<Integer> used){
		if (s>N){
			res++;
			return;
		}
		for (int i=1;i<=N;++i){
			if (!used.contains(i) && (i%s==0|| s%i==0)){
				used.add(i);
				dfs(s+1, N, used);
				used.remove(i);
			}
		}
	}
	public int countArrangement(int N) {
        dfs(1, N, new HashSet<>());
        return res;
    }
}
