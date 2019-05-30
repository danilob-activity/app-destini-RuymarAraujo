package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.londonappbrewery.destini.models.Answer;
import com.londonappbrewery.destini.models.Story;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;
    // TODO: Declare as variaveis aqui:
    Story mT1 = new Story(R.string.T1_Story);
    Story mT2 = new Story(R.string.T2_Story);
    Story mT3 = new Story(R.string.T3_Story);
    Story mT4 = new Story(R.string.T4_End);
    Story mT5 = new Story(R.string.T5_End);
    Story mT6 = new Story(R.string.T6_End);
    Answer mT1_ans1 = new Answer(R.string.T1_Ans1);
    Answer mT1_ans2 = new Answer(R.string.T1_Ans2);
    Answer mT2_ans1 = new Answer(R.string.T2_Ans1);
    Answer mT2_ans2 = new Answer(R.string.T2_Ans2);
    Answer mT3_ans1 = new Answer(R.string.T3_Ans1);
    Answer mT3_ans2 = new Answer(R.string.T3_Ans2);
    //indice corrente da historia
    private Story mStorySelected;
    private int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null) {
            mStoryIndex = savedInstanceState.getInt("StoryKey");
        }

        //1° TODO: Faça o link do layout com a activity

        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.buttonTop);
        mAnswerBottom = findViewById(R.id.buttonBottom);

        //TODO:faça o mapeamento da história=
        mT1.setAnswerTop(mT1_ans1);
        mT1.setAnswerBottom(mT1_ans2);
            mT1_ans1.setChildStory(mT3);
            mT1_ans2.setChildStory(mT2);
        mT2.setAnswerTop(mT2_ans1);
        mT2.setAnswerBottom(mT2_ans2);
            mT2_ans1.setChildStory(mT3);
            mT2_ans2.setChildStory(mT4);
        mT3.setAnswerTop(mT3_ans1);
        mT3.setAnswerBottom(mT3_ans2);
            mT3_ans1.setChildStory(mT6);
            mT3_ans2.setChildStory(mT5);



        mStorySelected = mT1;
        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());

        mAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStorySelected = mStorySelected.getAnswerTop().getChildStory();
                mStoryTextView.setText(mStorySelected.getStoryID());
                if (mStorySelected.getAnswerTop()==null){
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                } else {
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }
            }
        });

        mAnswerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStorySelected = mStorySelected.getAnswerBottom().getChildStory();
                mStoryTextView.setText(mStorySelected.getStoryID());
                if (mStorySelected.getAnswerBottom()==null){
                    mAnswerTop.setVisibility(View.GONE);
                    mAnswerBottom.setVisibility(View.GONE);
                } else {
                    mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                    mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
                }
            }
        });
        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):


    }
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryKey", mStoryIndex);



 }
}
