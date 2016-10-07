package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmooney from watts work
 * Just tells us if a Tweet is important or not
 * @use Tweet
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }


}
