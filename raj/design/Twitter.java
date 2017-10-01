package com.raj.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * @author Raj
 * 
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
 */
public class Twitter {

	Map<Integer, User> users = new HashMap<>();
	private static int timestamp = 0;

	/** Initialize your data structure here. */
	public Twitter() {
		users = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!users.containsKey(userId)) {
			users.put(userId, new User(userId));
		}
		users.get(userId).post(tweetId);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */

	// Best part of this.
	// first get all tweets lists from one user including itself and all people
	// it followed.
	// Second add all heads into a max heap. Every time we poll a tweet with
	// largest time stamp from the heap, then we add its next tweet into the
	// heap.
	// So after adding all heads we only need to add 9 tweets at most into this
	// heap before we get the 10 most recent tweet.
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> feed = new ArrayList<>();

		if (!users.containsKey(userId)) {
			return feed;
		}

		Set<Integer> followers = users.get(userId).followers;
		PriorityQueue<Tweet> pq = new PriorityQueue<>(followers.size(), (t1, t2) -> t2.time - t1.time);
		followers.forEach(follower -> {
			Tweet t_head = users.get(follower).tweet_head;
			if (t_head != null) {
				pq.add(t_head);
			}
		});
		int n = 0;
		while (!pq.isEmpty() && n < 10) {
			Tweet t = pq.poll();
			feed.add(t.id);
			n++;
			if (t.next != null) {
				pq.offer(t.next);
			}
		}
		return feed;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		if (!users.containsKey(followerId)) {
			users.put(followerId, new User(followerId));
		}

		if (!users.containsKey(followeeId)) {
			users.put(followeeId, new User(followeeId));
		}

		users.get(followerId).follow(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (!users.containsKey(followerId) || !users.containsKey(followeeId) || followerId == followeeId) {
			return;
		}
		users.get(followerId).unfollow(followeeId);
	}

	class User {
		Set<Integer> followers;
		int id;
		public Tweet tweet_head;

		public User(int id) {
			this.id = id;
			followers = new HashSet<>();
			follow(id);// first follow itself
		}

		public void follow(int id) {
			followers.add(id);
		}

		public void unfollow(int id) {
			followers.remove(id);
		}

		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweet_head;
			tweet_head = t;
		}

	}

	class Tweet {
		public int id;
		public int time;
		public Tweet next;

		public Tweet(int id) {
			this.id = id;
			this.time = timestamp++;
		}

	}

	public static void main(String... args) {
		Twitter twitter = new Twitter();

		List<Integer> feed = null;
		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		feed = twitter.getNewsFeed(1);
		System.out.println(feed);
		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet
		// id 5.
		feed = twitter.getNewsFeed(1);
		System.out.println(feed);

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		feed = twitter.getNewsFeed(1);
		System.out.println(feed);
	}

}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */