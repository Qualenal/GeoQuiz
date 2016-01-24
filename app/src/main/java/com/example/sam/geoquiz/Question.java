package com.example.sam.geoquiz;

/**
 * Abstract class to define a question for the quiz.
 * @author Sam Kennedy
 * @version 1.0
 * @see FillInBlankQuestion
 * @see MultipleChoiceQuestion
 * @see TrueFalseQuestion
 */
public abstract class Question {

    private int mTextResId;

    public Question(){
        mTextResId = 0;
    }

    /**
     * Superclass constructor to set the Question text.
     *
     * @param textResId
     */
    public Question(int textResId){
        mTextResId = textResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public abstract boolean isAnswerTrue();
}
