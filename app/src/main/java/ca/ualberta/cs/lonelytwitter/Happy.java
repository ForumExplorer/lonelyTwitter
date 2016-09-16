package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by mmooney on 9/15/16.
 */
public class Happy extends Mood{
    public Happy (Date today){
        super (today);

    }
    public String Emotion(){
        String Emotion;
        Emotion = "I am happy";
        return Emotion;
    }
}
