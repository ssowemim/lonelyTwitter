package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class LonleyTweetModel{
	private String text;
	protected Date timestamp;
	
	public String getText(){
	
		return text;
	}
	
	public void setText(String text){
	
		this.text = text;
	}
	
	public abstract Date getTimestamp();
	public abstract String getTypeTweet();
	
	public void setTimestamp(Date timestamp){
	
		this.timestamp = timestamp;
	}


	public LonleyTweetModel(String text){

		super();
		this.text = text;
		timestamp = new Date();
	}
	
	public LonleyTweetModel(String text, Date timestamp){

		super();
		this.text = text;
		this.timestamp = timestamp;
	}
	
	
}
