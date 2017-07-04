package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision399 {
	Map<String, List<String>> pair; 
    Map<String, List<Double>> valuePair; 
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int n = queries.length, m = equations.length;  
        if (n == 0) return new double[0];
        
        double[] res = new double[n]; 
        pair = new HashMap<>(); 
        valuePair = new HashMap<>(); 
        
        for (int i = 0; i < m; i++) {
            if (!pair.containsKey(equations[i][0])) {
                pair.put(equations[i][0], new LinkedList<>());
                valuePair.put(equations[i][0], new LinkedList<>()); 
            }
            if (!pair.containsKey(equations[i][1])) {
                pair.put(equations[i][1], new LinkedList<>()); 
                valuePair.put(equations[i][1], new LinkedList<>()); 
            }
            pair.get(equations[i][0]).add(equations[i][1]); 
            pair.get(equations[i][1]).add(equations[i][0]); 
            valuePair.get(equations[i][0]).add(values[i]); 
            valuePair.get(equations[i][1]).add(1 / values[i]); 
        }
        
        for (int i = 0; i < n; i++) {
            backTrack(queries[i][0], queries[i][1], new HashSet<String>(), 1.0, i, res); 
        }
        
        return res; 
    }
    
    public void backTrack(String start, String end, Set<String> set, double value, int pos, double[] res) {
        if (set.contains(start) || !pair.containsKey(start)) { res[pos] = -1.0; return; }  
        if (start.equals(end)) {res[pos] = value; return; }
        
        List<String> pairList = pair.get(start); 
        List<Double> valueList = valuePair.get(start); 
        
        set.add(start); 
        for (int i = 0; i < pairList.size(); i++) {
            backTrack(pairList.get(i), end, set, value * valueList.get(i), pos, res);   
            if (res[pos] != 0.0 && res[pos] != -1.0) return; // result already found. no need to keep searching. 
        }
        set.remove(start); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
