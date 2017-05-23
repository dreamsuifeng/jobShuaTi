package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
public class containsDuplicate3 {
	private class Node{
		int value;
		int index;
	}
	private class bstTree{
		
	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor((long)nums[ind] + (long)t);
            final Long ceil = values.ceiling((long)nums[ind] - (long)t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add((long)nums[ind]);
            if (ind >= k) {
                values.remove((long)nums[ind - k]);
            }
        }

        return false;
    }
	
	
	/* use bucket sort
	 * As a followup question, it naturally also requires maintaining a window of size k. When t == 0, 
	 * it reduces to the previous question so we just reuse the solution.

	Since there is now a constraint on the range of the values of the elements to be considered duplicates, 
	it reminds us of doing a range check which is implemented in tree data structure and would take O(LogN) 
	if a balanced tree structure is used, or doing a bucket check which is constant time. We shall just discuss
	the idea using bucket here.

	Bucketing means we map a range of values to the a bucket. For example, if the bucket size is 3, 
	we consider 0, 1, 2 all map to the same bucket. However, if t == 3, (0, 3) is a considered duplicates
	but does not map to the same bucket. This is fine since we are checking the buckets immediately before and after as well.
	So, as a rule of thumb, just make sure the size of the bucket is reasonable such that elements having the same bucket is 
	immediately considered duplicates or duplicates must lie within adjacent buckets. So this actually gives us a range of 
	possible bucket size, i.e. t and t + 1. We just choose it to be t and a bucket mapping to be num / t.

	Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0. 
	Therefore, we can just reposition every element to start from Integer.MIN_VALUE.
	 */
	public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
