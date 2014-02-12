package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetController implements TweetControllerInterface{
	private TweetListModel tweetListModel;
	
	
    public void addTweet(String text){
        LonelyTweetModel It = new NormalTweetModel(text);
        ArrayList<LonelyTweetModel> list = tweetListModel.getList();
        list.add(It);
}
	
    public TweetController()
    {
            super();
            if (tweetListModel == null){
            tweetListModel = new TweetListModel();
            }
    }

}
