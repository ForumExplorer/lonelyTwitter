/*
Copyright (C) 2016 Team 20 CMPUT301, University of Alberta - All rights reserved.
You may use, copy or distribute this code under tyerms and conditions of University of Alberta
and Code of Student Behavior
Please contacty abc@abc,ca for more details or questions.
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {
/*
This is the name of the file that is save in your virtual device.
You can access it through Android Device Monitor by selecting your app,
then data -> data -> file.sav
Displays, collects, and retrieves Tweets.

 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> tweetAdapter;
	
	@Override
	/*
	Creates the buttons and collects the text that is passed to a tweet.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Date theDate = new Date();
				Tweet newTweet = new NormalTweet(text);
				newTweet.getMessage();
				tweetList.add(newTweet);
				tweetAdapter.notifyDataSetChanged();
				saveInFile();

			}
		});
		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				setResult(RESULT_OK);
				tweetList.clear();
				tweetAdapter.notifyDataSetChanged();
				clearInFile();
			}
		});
	}

	@Override
	//just loads the saved file when the app starts.
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();
		tweetAdapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(tweetAdapter);
	}
/*
This method loads the json file and generates the tweets from its contents.
*@exception FileNotFoundException
* @throws RuntimeException
*
 */
	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt on September 22nd 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	/**
	 * Saves the tweetList to the file.sav.
	 * @Catch FileNotFoundException
	 * @Catch IOException
	 * @throws RuntimeException
	 */
	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	/*
	Rewrites the save file with nothing in order to clear it.
	 */
	private void clearInFile(){
		try{
			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e){
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}