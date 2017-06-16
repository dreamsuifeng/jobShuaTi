package LeetCode;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class twitt {
	int timestamp;
	int twid;

	public twitt(int i, int t) {
		timestamp = t;
		twid = i;
	}
}

public class DesignTwitter355 {
	int time;
	Map<Integer, Set<Integer>> twitterid;
	Map<Integer, LinkedList<twitt>> tweetts;

	/** Initialize your data structure here. */
	public DesignTwitter355() {
		time = 0;
		twitterid = new HashMap<>();
		tweetts = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (tweetts.containsKey(userId)) {
			tweetts.get(userId).addFirst(new twitt(tweetId, time++));
		} else {
			LinkedList<twitt> tList = new LinkedList<>();
			tList.addFirst(new twitt(tweetId, time++));
			tweetts.put(userId,tList);
// 			System.out.println(tweetts);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res=new LinkedList<>();
		PriorityQueue<LinkedList<twitt>> queue = new PriorityQueue<LinkedList<twitt>>(
				(x, y) -> (y.peek().timestamp - x.peek().timestamp));
		if (tweetts.containsKey(userId))
            queue.add(new LinkedList<twitt>(tweetts.get(userId)));
        if (twitterid.containsKey(userId)){
    		Iterator<Integer> it = twitterid.get(userId).iterator();
    		while (it.hasNext()) {
    		    Integer t=it.next();
    		    if (tweetts.containsKey(t)){
    			    queue.add(new LinkedList<twitt>(tweetts.get(t)));
    		    }
    		}
        }
    		int n=0;
    		while (n<10 && !queue.isEmpty()){
    			LinkedList<twitt> tmp=queue.poll();
    			if (!tmp.isEmpty())
    			    res.add(tmp.poll().twid);
    			if (!tmp.isEmpty()) {
    				queue.add(tmp);
    			}
    			n++;
    		}
        
		return res;
	}

	private Set<Integer> addint(Set<Integer> ori, int i) {
		ori.add(i);
		return ori;
	}
	private Set<Integer> followfun(Set<Integer> v, int val){
		if (v==null){
			Set<Integer> tmp=new HashSet<>();
			tmp.add(val);
			return tmp;
		}else{
			v.add(val);
			return v;
		}
	}
	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
	    if (followerId==followeeId) return;
		twitterid.compute(followerId, (k,v)->followfun(v, followeeId));
// 		System.out.println(twitterid.toString());
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	private Set<Integer> removeInt(Set<Integer> ori, int index) {
		ori.remove(index);
		return ori;
	}

	public void unfollow(int followerId, int followeeId) {
		twitterid.computeIfPresent(followerId, (k, v) -> this.removeInt(v, followeeId));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
