package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private int mIndex;
    private int mStorie;
    private int mButtonT;
    private int mEnd;
    private int mButtonB;
    private int verify = 0;
    TextView mTextView;
    Button mButtonTop;
    Button mButtonBottom;


    private Stories[] mStoriesBank = new Stories[]{
            new Stories(R.string.T1_Story),
            new Stories(R.string.T2_Story),
            new Stories(R.string.T3_Story),
    };

    private Ends[] mEndsBank = new Ends[]{
            new Ends(R.string.T4_End),
            new Ends(R.string.T5_End),
            new Ends(R.string.T6_End),
    };

    private TopButton[] mTopButtonBank = new TopButton[]{
            new TopButton(R.string.T1_Ans1),
            new TopButton(R.string.T2_Ans1),
            new TopButton(R.string.T3_Ans1),
    };

    private BottomButton[] mBottomButtonBank = new BottomButton[]{
            new BottomButton(R.string.T1_Ans2),
            new BottomButton(R.string.T2_Ans2),
            new BottomButton(R.string.T3_Ans2),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mIndex = savedInstanceState.getInt("IndexKey");
            verify = savedInstanceState.getInt("VerifyKey");

        }else{
            mIndex = 0;
            verify = 0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        if(verify == 0) {
            mStorie = mStoriesBank[mIndex].getTextViewid();
            mTextView.setText(mStorie);
            mButtonT = mTopButtonBank[mIndex].getButtonId();
            mButtonTop.setText(mButtonT);
            mButtonB = mBottomButtonBank[mIndex].getButtonId();
            mButtonBottom.setText(mButtonB);
        }else{
            mEnd = mEndsBank[mIndex].getEndId();
            mTextView.setText(mEnd);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTopButton();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBottomButton();
            }
        });

    }

    private void updateTopButton(){
        if(mIndex == 0){
            mIndex = 2;
            mStorie = mStoriesBank[mIndex].getTextViewid();
            mTextView.setText(mStorie);
            mButtonT = mTopButtonBank[mIndex].getButtonId();
            mButtonTop.setText(mButtonT);
            mButtonB = mBottomButtonBank[mIndex].getButtonId();
            mButtonBottom.setText(mButtonB);
        }else if(mIndex == 1) {
            mIndex = 2;
            mStorie = mStoriesBank[mIndex].getTextViewid();
            mTextView.setText(mStorie);
            mButtonT = mTopButtonBank[mIndex].getButtonId();
            mButtonTop.setText(mButtonT);
            mButtonB = mBottomButtonBank[mIndex].getButtonId();
            mButtonBottom.setText(mButtonB);
        }else if(mIndex == 2){
            mEnd = mEndsBank[mIndex].getEndId();
            mTextView.setText(mEnd);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            verify = 1;
        }
    }

    private void updateBottomButton(){
        if(mIndex == 0){
            mIndex = 1;
            mStorie = mStoriesBank[mIndex].getTextViewid();
            mTextView.setText(mStorie);
            mButtonT = mTopButtonBank[mIndex].getButtonId();
            mButtonTop.setText(mButtonT);
            mButtonB = mBottomButtonBank[mIndex].getButtonId();
            mButtonBottom.setText(mButtonB);
        }else if(mIndex == 1){
            mIndex = 0;
            mEnd = mEndsBank[mIndex].getEndId();
            mTextView.setText(mEnd);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            verify = 1;
        }else if(mIndex == 2){
            mIndex = 1;
            mEnd = mEndsBank[mIndex].getEndId();
            mTextView.setText(mEnd);
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            verify = 1;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("IndexKey", mIndex);
        outState.putInt("VerifyKey", verify);
    }
}
