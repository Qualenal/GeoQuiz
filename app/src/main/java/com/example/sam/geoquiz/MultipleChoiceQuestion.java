package com.example.sam.geoquiz;

/**
 * Created by qualenal on 1/21/16.
 */
public class MultipleChoiceQuestion extends Question {
    private int[] mAnswers;
    private int mCorrectAnswer;
    private int mUserAnswer = -1;

    public MultipleChoiceQuestion(int textResId, int[] mAnswers, int mCorrectAnswer) {
        super(textResId);
        this.mAnswers = mAnswers;
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public int[] getAnswers() {
        return mAnswers;
    }

    public void setAnswers(int[] answers) {
        mAnswers = answers;
    }

    public int getUserAnswer() {
        return mUserAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        mUserAnswer = userAnswer;
    }

    @Override
    public boolean isAnswerTrue() {
        return mUserAnswer == mCorrectAnswer;
    }
}
