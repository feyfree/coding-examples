package com.feyfree.leetcode.p0355;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 设计推特
 *
 * @author leilei
 */
class Twitter {

    /**
     * 存储每个人的 关注者
     */
    private Map<Integer, Set<Integer>> followers;

    /**
     * 存储每个人 当前关注
     */
    private Map<Integer, Set<Integer>> following;

    /**
     * tweetId 递增
     */
    private AtomicInteger atomicInteger;

    /**
     * 存储每个人的推特ID
     */
    private Map<Integer, List<Integer>> tweetsMap;

    private int[] tweetsArray;

    public Twitter() {
        this.followers = new HashMap<>();
        this.following = new HashMap<>();
        this.atomicInteger = new AtomicInteger();
        this.tweetsMap = new HashMap<>();
        this.tweetsArray = new int[10000 + 2];
        Arrays.fill(this.tweetsArray, -1);
    }

    public void postTweet(int userId, int tweetId) {
        // 可以考虑并发233
        tweetsArray[atomicInteger.getAndIncrement()] = tweetId;
        List<Integer> tweets = tweetsMap.get(userId);
        if (tweets == null) {
            tweets = new ArrayList<>();
            tweets.add(tweetId);
            tweetsMap.put(userId, tweets);
        } else {
            tweets.add(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        return null;
    }

    public void follow(int followerId, int followeeId) {

    }

    public void unfollow(int followerId, int followeeId) {

    }
}
