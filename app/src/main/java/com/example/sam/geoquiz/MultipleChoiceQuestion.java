package com.example.sam.geoquiz;

/**
 * Model for Multiple Choice Questions.
 *
 * @author Sam Kennedy
 * @version 1.0
 */
public class MultipleChoiceQuestion extends Question {
    /**
     * Array of string ids that are the multiple-choice answers.
     */
    private int[] mAnswers;
    /**
     * Integer that holds the correct answer 1-4.
     */
    private int mCorrectAnswer;
    /**
     * Integer that holds the user's answer, initialized to -1.
     */
    private int mUserAnswer = -1;

    /**
     * Constructor that requires all fields.
     *
     * @param textResId
     * @param mAnswers
     * @param mCorrectAnswer
     */
    public MultipleChoiceQuestion(int textResId, int[] mAnswers, int mCorrectAnswer) {
        super(textResId);
        this.mAnswers = mAnswers;
        this.mCorrectAnswer = mCorrectAnswer;
    }

    /**
     * Getter for the array of ids that are the answers.
     * @return
     */
    public int[] getAnswers() {
        return mAnswers;
    }

    /**
     * Setter for the array of ids that are the answers.
     * @param answers
     */
    public void setAnswers(int[] answers) {
        mAnswers = answers;
    }

    /**
     * Getter for the user's answer.
     * @return
     */
    public int getUserAnswer() {
        return mUserAnswer;
    }

    /**
     * Setter for the user's answer.
     * @param userAnswer
     */
    public void setUserAnswer(int userAnswer) {
        mUserAnswer = userAnswer;
    }

    /**
     * Implementation of abstract function to check user's answer.
     * @return
     */
    @Override
    public boolean isAnswerTrue() {
        return mUserAnswer == mCorrectAnswer;
    }
}
