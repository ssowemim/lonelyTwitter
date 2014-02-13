package ca.ualberta.cs.lonelytwitter.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(String text) {
		assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
		textInput.setText(text);
		((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
	}
	
	public void testAddTweet() throws Throwable{
		runTestOnUiThread(new Runnable()
		{
			
			@Override
			public void run(){
				
				String text = "Hi There #testing";
			
				// TODO Auto-generated method stub
				@SuppressWarnings("rawtypes")
				ArrayAdapter adapter = ((LonelyTwitterActivity) activity).getListViewAdapter();
				int before = adapter.getCount();
				makeTweet(text);
				int after = adapter.getCount();
				
				
				assertEquals("Tweet count should increase by one in array adapter",before+1, after);
				Object lastObj = adapter.getItem(after-1);
				assertEquals("Checking if last object in adapter is a NTM",true, lastObj instanceof NormalTweetModel);
				assertEquals("Checking if text in adapter is correct", text, ((NormalTweetModel)lastObj).getText());
			}
		});
	}

}
