package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListModel{
	private static ArrayList<LonleyTweetModel> tweetList;

	
	public ArrayList<LonleyTweetModel> getTweetList(){
	
		return tweetList;
	}

	
	public void setTweetList(ArrayList<LonleyTweetModel> tweetList){
	
		this.tweetList = tweetList;
	}


	public TweetListModel(){

		super();
		tweetList = new ArrayList<LonleyTweetModel>();
	}
	
	
}
