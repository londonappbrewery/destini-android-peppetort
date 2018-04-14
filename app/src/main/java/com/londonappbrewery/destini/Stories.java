package com.londonappbrewery.destini;

public class Stories {

    private int mTextViewid;

    public Stories(int storyResurceId){
        mTextViewid = storyResurceId;
    }

    public int getTextViewid(){
        return mTextViewid;
    }

    public void setTextViewid(int textId){
        mTextViewid = textId;
    }
}
