package com.example.sam.geoquiz;

import android.widget.LinearLayout;

/**
 * Created by qualenal on 1/21/16.
 */
public class FillInBlankQuestion extends Question {
    private String mAnswer;
    private String mUserAnswer;

    public FillInBlankQuestion(int textResId, String answer) {
        super(textResId);
        mAnswer = answer;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public String getUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        mUserAnswer = userAnswer;
    }

    @Override
    public boolean isAnswerTrue() {
        return mUserAnswer.equalsIgnoreCase(mAnswer);
    }
}
