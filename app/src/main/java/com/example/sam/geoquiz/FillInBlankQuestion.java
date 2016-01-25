package com.example.sam.geoquiz;

/**
 * Model for Fill in the Blank Questions.
 *
 * @author Sam Kennedy
 * @version 1.0
 */
public class FillInBlankQuestion extends Question {
    /**
     * String representation of correct answer.
     */
    private String mAnswer;
    /**
     * String representation of user's answer.
     */
    private String mUserAnswer;

    /**
     * Constructor that requires the correct answer to be supplied.
     * @param textResId
     * @param answer
     */
    public FillInBlankQuestion(int textResId, String answer) {
        super(textResId);
        mAnswer = answer;
    }

    /**
     * Getter for the correct answer.
     * @return
     */
    public String getAnswer() {
        return mAnswer;
    }

    /**
     * Setter for the correct answer.
     * @param answer
     */
    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    /**
     * Getter for user's answer.
     * @return
     */
    public String getUserAnswer() {
        return mUserAnswer;
    }

    /**
     * Setter for user's answer.
     * @param userAnswer
     */
    public void setUserAnswer(String userAnswer) {
        mUserAnswer = userAnswer;
    }

    /**
     * Implementation of abstract function that checks the user's answer.
     *
     * Ignores case when checking answer.
     * @return
     */
    @Override
    public boolean isAnswerTrue() {
        return mUserAnswer.equalsIgnoreCase(mAnswer);
    }
}
