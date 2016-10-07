package ca.ualberta.cs.lonelytwitter;

/**
 * Created by mmooney from watts work
 * Basically just says a tweet is not important.
 * @use Tweet
 *
 */
public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
