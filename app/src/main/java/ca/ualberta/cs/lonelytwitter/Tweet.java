package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mmooney on 9/15/16.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<Mood> mood;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date, Mood mood){
        this.message = message;
        this.date = date;
        this.mood.add(mood);
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do something! Do ANYTHING!
            throw new TweetTooLongException();
        }
        this.message = message;
    }
    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }
}
