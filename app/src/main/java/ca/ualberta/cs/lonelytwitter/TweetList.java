package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

/**
 * Created by mmooney on 9/29/16.
 * An array list of tweets, that contains every created tweet. It should be able to detect
 * if a tweet already exists and reject an identical one.
 * @use Tweet
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){

    }
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public void add(Tweet tweet){
        tweets.add(tweet);

    }
    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public boolean contains (Tweet tweet){
        return tweets.contains(tweet);
    }
    /**
     * Checks to see if a tweet exists and rejects duplicates
     * @throws IllegalArgumentException
     */
    public void addTweet(Tweet tweet){
        if(contains(tweet)){
            throw new IllegalArgumentException();
        }
    }
    public void getTweets();
}
