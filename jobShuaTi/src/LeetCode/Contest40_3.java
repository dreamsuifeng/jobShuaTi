package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Contest40_3 {
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int basePrice = 0;
		for (int i = 0; i < price.size(); i++) {
			basePrice += price.get(i) * needs.get(i);
		}
        for (int i = 0; i < special.size(); i++) {
        	List<Integer> cp = special.get(i);
        	boolean feasible = true;
        	int currPrice = 0;
        	for (int j = 0; j < needs.size() && feasible; j++) {
        		if (cp.get(j) > needs.get(j)) {
        			feasible = false;
        		} else {
        			currPrice += cp.get(j) * price.get(j);
        		}
        	}
        	if (feasible && currPrice > cp.get(needs.size())) {
        		List<Integer> newNeeds = new ArrayList<>();
        		for (int j = 0; j < needs.size(); j++) {
        			newNeeds.add(needs.get(j) - cp.get(j));
        		}
        		int newPrice = cp.get(needs.size()) + shoppingOffers(price, special, newNeeds);
        		if (newPrice < basePrice) {
        			basePrice = newPrice;
        		}
        	}
        }
		return basePrice;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
