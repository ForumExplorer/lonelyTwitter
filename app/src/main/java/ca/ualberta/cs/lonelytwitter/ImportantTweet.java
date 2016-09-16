package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmooney on 9/15/16.
 */
public class ImportantTweet extends Tweet{

    public ImportantTweet(String message){
        super (message);

    }
    @Override //doesn't do anything, just lets people know about it.
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
