package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DesignTwitter355 {
	Map<Integer, Set<Integer>> twitterid;
	
	/** Initialize your data structure here. */
	public DesignTwitter355() {
		twitterid = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		List<Integer> userFollowed=new
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {

	}
	private Set<Integer> addint(Set<Integer> ori,int i){
		ori.add(i);
		return ori;
	}
	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
       twitterid.computeIfAbsent(followerId,k -> new HashSet<Integer>(followeeId));
       twitterid.computeIfPresent(followerId, (k,v) -> this.addint(v, followeeId));
    }

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
    private Set<Integer> removeInt(Set<Integer> ori,int index){
    	ori.remove(index);
    	return ori;
    }
	public void unfollow(int followerId, int followeeId) {
		twitterid.computeIfPresent(followerId, (k,v) -> this.removeInt(v,followeeId));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
