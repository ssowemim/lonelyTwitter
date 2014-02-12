package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public class NormalTweetModel extends LonelyTweetModel{

    @SuppressWarnings("unused")
    private boolean important;
    
    public NormalTweetModel(String text, Date timestamp){
            super(text, timestamp);
            // TODO Auto-generated constructor stub
    }

    public NormalTweetModel(String text){
            super(text);
            // TODO Auto-generated constructor stub
    }

    @Override
    public void setText(String text){
            // TODO Auto-generated method stub
    }

    @Override
    public boolean isNormal(){
            return true;
    }
    //this is extra (someone else's solution but demos exceptions so here it is:
    @Override
    public void setImportant(boolean important) throws Exception {
            if (important){
                    throw new Exception();
            }
            this.important = important;
    }

}