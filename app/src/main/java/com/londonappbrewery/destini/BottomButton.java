package com.londonappbrewery.destini;

public class BottomButton {

    private int mButtonBottomId;

    public BottomButton(int mButtonBottomId){
        this.mButtonBottomId = mButtonBottomId;
    }

    public int getButtonId(){
        return this.mButtonBottomId;
    }

    public void setButtonId(int buttonId){
        mButtonBottomId = buttonId;
    }
}
