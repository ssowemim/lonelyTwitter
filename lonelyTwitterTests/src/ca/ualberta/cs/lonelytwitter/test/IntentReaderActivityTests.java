package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


public class IntentReaderActivityTests extends ActivityInstrumentationTestCase2<IntentReaderActivity>{
	public IntentReaderActivityTests(){
		super(IntentReaderActivity.class);
	}

	public void testSendText(){
		Intent intent = new Intent();
		String text ="hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();

		assertNotNull(activity);

		assertEquals("IntentReaderActivity Should get text from intent", text, activity.getText());
	}
	public void testDoubleText(){
		Intent intent = new Intent();
		String text ="hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();

		assertNotNull(activity);
		assertEquals("IntentReaderActivity should get text from intent", text + text, activity.getText());
	}

	public void testDisplayText(){
		Intent intent = new Intent();
		String text ="hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();

		assertNotNull(activity);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity  should display text", text, textView.getText().toString());
	}
	
	public void testReverseText(){
		Intent intent = new Intent();
		String text = "Wassup";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		assertEquals("IntentReaderActivity should return reversed text", new StringBuilder(text).reverse().toString(),activity.getText());
		
	}
	
	/**public void testNullTextOne(){
		Intent intent = new Intent();
		String text = null;
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		assertEquals("IntentReaderActivity Should get text from intent", text, activity.getText());
		
	}
	
	public void testNullTextTwo(){
		Intent intent = new Intent();
		String text = "";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		
		IntentReaderActivity activity = getActivity();
		
		assertNotNull(activity);
		assertEquals("IntentReaderActivity Should get text from intent", text, activity.getText());
		
	} **/
	
	public void testNullText(){
		Intent intent = new Intent();
		String text = null;
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		
		
		IntentReaderActivity activity = getActivity();
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertNotNull(activity);
		assertEquals("IntentReaderActivity text should be default text", activity.getDefaultText(), activity.getText());
		assertEquals("IntentReaderActivity view text should be default text", activity.getDefaultText(), textView.getText());		
		
	}
	
	public void testDisplayViewText(){
		Intent intent = new Intent();
		String text ="hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();

		assertNotNull(activity);
		
		View view =  activity.getWindow().getDecorView();
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);

		ViewAsserts.assertOnScreen(view, textView);
	}
	

}
