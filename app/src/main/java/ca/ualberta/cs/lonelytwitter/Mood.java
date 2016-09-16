package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmooney on 9/15/16.
 */
public abstract class Mood {
    public  Date today;

   public abstract String Emotion();

    public Mood (Date today){
        this.today = today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getToday() {
        return today;
    }
}
