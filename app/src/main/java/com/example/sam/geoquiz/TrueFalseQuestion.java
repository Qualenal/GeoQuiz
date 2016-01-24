package com.example.sam.geoquiz;

/**
 * Created by qualenal on 1/21/16.
 */
public class TrueFalseQuestion extends Question {
    private boolean mAnswer;
    private boolean mUserAnswer;

    public TrueFalseQuestion(int textResId, boolean answerTrue) {
        super(textResId);
        mAnswer = answerTrue;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }

    public boolean isUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        mUserAnswer = userAnswer;
    }

    @Override
    public boolean isAnswerTrue() {
        return mAnswer == mUserAnswer;
    }
}
