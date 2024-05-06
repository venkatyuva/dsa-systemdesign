package com.dsa.heaps;

import java.util.*;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
    private Map<Integer, List<Integer>> followersMap;

    private Map<Integer, Tweet> tweetsMap;

    private int time;
    // Initialize your data structure here
    Twitter() {
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        time = 1;
    }

    // Compose a new tweet
    void postTweet(int userId, int tweetId) {
        Tweet existingTweet = tweetsMap.get(userId);
        if (existingTweet == null) {
            existingTweet = new Tweet(tweetId, time++);
        } else {
            Tweet tweet = new Tweet(tweetId, time++);
            tweet.next = existingTweet;
            existingTweet = tweet;
        }
        tweetsMap.put(userId, existingTweet);
    }

    // Retrieve the 10 most recent tweet ids as mentioned in question
    List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>(new Comparator<Tweet>(){
            @Override
            public int compare(Tweet tweet1, Tweet tweet2) {
                return tweet2.time - tweet1.time;
            }
        });
        if (tweetsMap.get(userId) != null) {
            minHeap.add(tweetsMap.get(userId));
        }
        for (int followers : followersMap.getOrDefault(userId, new ArrayList<>())) {
            if (tweetsMap.get(followers) != null) {
                minHeap.add(tweetsMap.get(followers));
            }
        }
        int count = 0;
        List<Integer> newsFeed = new ArrayList<>();
        while (count < 10 && !minHeap.isEmpty()) {
            Tweet tweet = minHeap.poll();
            newsFeed.add(tweet.tweetId);
            if (tweet.next != null) {
                minHeap.add(tweet.next);
            }
            count++;
        }
        return newsFeed;
    }

    // Follower follows a followee. If the operation is invalid, it should be a
    // no-op.
    void follow(int followerId, int followeeId) {
        followersMap.putIfAbsent(followerId, new ArrayList<>());
        followersMap.get(followerId).add(followeeId);
    }

    // Follower unfollows a followee. If the operation is invalid, it should be
    // a no-op.
    void unfollow(int followerId, int followeeId) {
        List<Integer> followers = followersMap.getOrDefault(followerId, new ArrayList<>());
        if (followers.contains(followeeId)) {
            followers.remove(Integer.valueOf(followeeId));
        }
    }
}
class Tweet {
    int tweetId;
    int time;
    Tweet next;
    public Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
        this.next = null;
    }
}