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
    /**
     * Field to hold the question text.
     */
    private int mTextResId;

    /**
     * Default constructor sets text id to 0.
     */
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

    /**
     * Getter for question text.
     * @return
     */
    public int getTextResId() {
        return mTextResId;
    }

    /**
     * Setter for question text.
     * @param textResId
     */
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    /**
     * Abstract function that requires children to be able to check the user's answer.
     * @return
     */
    public abstract boolean isAnswerTrue();
}
