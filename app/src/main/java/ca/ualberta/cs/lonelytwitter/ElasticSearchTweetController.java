package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.util.ArrayList;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.SearchResult;

/**
 * Created by mmooney on 10/20/16.
 */
public class ElasticSearchTweetController {

    private static JestDroidClinet clinet;

    private static class AddTweetsTask extends AsyncTast<NormalTweet, Void, Void>{
        @Override
        protected Void doInBackground (NormalTweet... tweets) {
            for (NormalTweet tweet : tweets) {
                Index index = new Index.Builder(tweet).index("texting").type("tweet").build();

                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()){
                        tweet.setId(result.getId());
                    }

                } catch (Exception e) {
                    Log.i("Error", "The application failed to build and send the tweets");
                }
            }
        return null;
        }
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<NormalTweet>>{
        @Override
        protected ArrayList<NormalTweet> doInBackground(String... searchParameters) {
            try {
                SearchResult result = client.execute(search);
                if (result.isSucceeded()) {

                } else {
                    Log.i("Error", "The search executed but it didn't work");
                }
            } catch (Exception e) {
                Log.i("Error", "Executed the get method failed");
            }

        }
    }

    public static void verifySettings(){
        if (client == null) {
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }


}
