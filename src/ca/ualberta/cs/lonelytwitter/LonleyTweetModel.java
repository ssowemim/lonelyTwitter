package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class LonleyTweetModel{
	private String text;
	private Date timestamp;
	
	public String getText(){
	
		return text;
	}
	
	public void setText(String text){
	
		this.text = text;
	}
	
	public Date getTimestamp(){
	
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp){
	
		this.timestamp = timestamp;
	}
	
	
	
}
