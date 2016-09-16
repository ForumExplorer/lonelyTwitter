package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmooney on 9/15/16.
 */
public class Sad extends Mood{
    public Sad (Date today){
        super (today);
    }

    @Override
    public String Emotion() {
        String Emotion;
        Emotion = "Sorry, really not feeling up to it right now.";
        return Emotion;
    }
}
