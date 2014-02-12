package ca.ualberta.cs.lonelytwitter;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

<<<<<<< HEAD:lonelyTwitter/src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
	private static final String FILENAME = "file.json";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<NormalTweetModel> tweets;
	private ArrayAdapter<NormalTweetModel> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				NormalTweetModel tweet = new NormalTweetModel(text);
				saveInFile(tweet);
				tweets.add(tweet);
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		tweets = loadFromFile();
		adapter = new ArrayAdapter<NormalTweetModel>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(NormalTweetModel.fromJSON(line));
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	public ArrayAdapter getListViewAdapter() {
		return (ArrayAdapter)adapter;
	} 
	
	private void saveInFile(NormalTweetModel tweet) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write((tweet.toJSON() + "\n").getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
=======
        private static final String FILENAME = "file.sav";
        
        private EditText bodyText;
        private ListView oldTweetsList;
        protected ArrayAdapter<String>listAdapter;
        public static final String LOG_TAG = "myLogs";
        
        ArrayList<String> tweets;
        Gson gson = new Gson();
        
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);

                bodyText = (EditText) findViewById(R.id.body);
                Button saveButton = (Button) findViewById(R.id.save);
                oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

                saveButton.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                                
                                setResult(RESULT_OK);
                                String text = bodyText.getText().toString();
                                NormalTweetModel ntm = new NormalTweetModel(text, new Date(System.currentTimeMillis()));
                                String jsonString = gson.toJson(ntm);
                                saveInFile(jsonString + "\n");
                                tweets.add(ntm.getText() + ntm.getTimestamp());
                                
//                                saveInFile(text, new Date(System.currentTimeMillis()));
//                                tweets.add(text);
                                listAdapter.notifyDataSetChanged();

                                
                        }
                });
        }

        @Override
        protected void onStart() {
                // TODO Auto-generated method stub
                super.onStart();

                tweets = loadFromFile();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                R.layout.list_item, tweets);
                oldTweetsList.setAdapter(adapter);
                listAdapter = adapter;

        }

        private ArrayList<String> loadFromFile() {
                ArrayList<String> tweets = new ArrayList<String>();
                
               // NormalTweetModel ntm1 = new NormalTweetModel();

                try {
                        FileInputStream fis = openFileInput(FILENAME);
                        BufferedReader in = new BufferedReader(new InputStreamReader(fis));     
                        String line = in.readLine();
                        
                        while (line != null) {
                        	
                            NormalTweetModel ntm1 = gson.fromJson(line, NormalTweetModel.class);
                               tweets.add(ntm1.getText() + ntm1.getTimestamp());
                               line = in.readLine();
                        }

                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return tweets;
        }
        
        private void saveInFile(String text) {
                try {
                        FileOutputStream fos = openFileOutput(FILENAME,
                                        Context.MODE_APPEND);
                        fos.write(text.getBytes());
                        fos.close();
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        
/*        private void saveInFile(String text, Date date) {
                try {
                        FileOutputStream fos = openFileOutput(FILENAME,
                                        Context.MODE_APPEND);
                        fos.write(new String(date.toString() + " | " + text)
                                        .getBytes());
                        fos.close();
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }
        */
>>>>>>> 4fd5fe257c990ff8b79ee09a2b9c682963478361:src/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java
}