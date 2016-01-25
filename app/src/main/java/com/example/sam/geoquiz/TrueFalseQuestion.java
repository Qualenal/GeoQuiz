package com.example.sam.geoquiz;

/**
 * This class is a model for True and False questions.
 *
 * @author Sam Kennedy
 * @version 1.0
 */
public class TrueFalseQuestion extends Question {
    /**
     * Holds the true or false correct answer.
     */
    private boolean mAnswer;
    /**
     * Holds the user's answer.
     */
    private boolean mUserAnswer;

    /**
     * Constructor for the True False Questions.
     *
     * @param textResId
     * @param answerTrue
     */
    public TrueFalseQuestion(int textResId, boolean answerTrue) {
        super(textResId);
        mAnswer = answerTrue;
    }

    /**
     * Getter for the correct answer.
     *
     * @return
     */
    public boolean isAnswer() {
        return mAnswer;
    }

    /**
     * Setter for correct answer.
     * @param answer
     */
    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }

    /**
     * Getter for user's answer.
     * @return
     */
    public boolean isUserAnswer() {
        return mUserAnswer;
    }

    /**
     * Setter for user's answer.
     * @param userAnswer
     */
    public void setUserAnswer(boolean userAnswer) {
        mUserAnswer = userAnswer;
    }

    /**
     * Implementation of abstract function to check user's answer.
     * @return
     */
    @Override
    public boolean isAnswerTrue() {
        return mAnswer == mUserAnswer;
    }
}
