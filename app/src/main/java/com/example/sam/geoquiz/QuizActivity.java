package com.example.sam.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The sole activity that controls the only screen in this app.
 *
 * @author Sam Kennedy
 * @version 1.0
 */
public class QuizActivity extends AppCompatActivity {
    /**
     * TextView object used to hold the question text.
     */
    private TextView mQuestionTextView;

    /**
     * Array of Questions that the user is asked.
     */
    private Question[] mQuestionBank = new Question[] {
            new TrueFalseQuestion(R.string.question_oceans, true),
            new MultipleChoiceQuestion(R.string.question_beer, new int[]{R.string.answer_beer_one,
                    R.string.answer_beer_two,R.string.answer_beer_three,R.string.answer_beer_four},1),
            new FillInBlankQuestion(R.string.question_capital,"Denver")
    };
    /**
     * A counter to keep track of the current question.
     */
    private int mCurrentIndex = 0;

    /**
     * Method that adds the text to multiple choice buttons.
     */
    private void setUpQuestions(){
        ((MultipleChoiceQuestion) mQuestionBank[1]).setAnswers(new int[]{R.string.answer_beer_one,
                R.string.answer_beer_two, R.string.answer_beer_three, R.string.answer_beer_four});
    }

    /**
     * This method updates the view based on the current Question being asked.
     *
     * It also adds click listeners to Question-specific buttons.
     */
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
        if(mQuestionBank[mCurrentIndex] instanceof TrueFalseQuestion){
            findViewById(R.id.true_false_view).setVisibility(View.VISIBLE);
            findViewById(R.id.mc_question_view).setVisibility(View.GONE);
            findViewById(R.id.fill_in_question_layout).setVisibility(View.GONE);
        } else if (mQuestionBank[mCurrentIndex] instanceof FillInBlankQuestion) {

            findViewById(R.id.true_false_view).setVisibility(View.GONE);
            findViewById(R.id.mc_question_view).setVisibility(View.GONE);
            findViewById(R.id.fill_in_question_layout).setVisibility(View.VISIBLE);

            Button mSubmitButton = (Button) findViewById(R.id.submit_button);
            final EditText mTextField = (EditText) findViewById(R.id.submit_text_area);
            mSubmitButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    FillInBlankQuestion q = (FillInBlankQuestion) mQuestionBank[mCurrentIndex];
                    String answer = mTextField.getText().toString().trim();
                    q.setUserAnswer(answer);
                    checkAnswer();
                }
            });

        } else if (mQuestionBank[mCurrentIndex] instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion q = (MultipleChoiceQuestion) mQuestionBank[mCurrentIndex];
            findViewById(R.id.true_false_view).setVisibility(View.GONE);
            findViewById(R.id.mc_question_view).setVisibility(View.VISIBLE);
            findViewById(R.id.fill_in_question_layout).setVisibility(View.GONE);

            Button mMcButtonOne = (Button) findViewById(R.id.mc_button_one);
            Button mMcButtonTwo = (Button) findViewById(R.id.mc_button_two);
            Button mMcButtonThree = (Button) findViewById(R.id.mc_button_three);
            Button mMcButtonFour = (Button) findViewById(R.id.mc_button_four);
            mMcButtonOne.setText(q.getAnswers()[0]);
            mMcButtonTwo.setText(q.getAnswers()[1]);
            mMcButtonThree.setText(q.getAnswers()[2]);
            mMcButtonFour.setText(q.getAnswers()[3]);
            mMcButtonOne.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ((MultipleChoiceQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(1);
                    checkAnswer();
                }
            });

            mMcButtonTwo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ((MultipleChoiceQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(2);
                    checkAnswer();
                }
            });

            mMcButtonThree.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ((MultipleChoiceQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(3);
                    checkAnswer();
                }
            });

            mMcButtonFour.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ((MultipleChoiceQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(4);
                    checkAnswer();
                }
            });
        }
    }

    /**
     * This method checks to see if the user's answer was correct, and updates the view accordingly.
     *
     * @see Question#isAnswerTrue()
     */
    private void checkAnswer() {
        boolean answerIsCorrect =  mQuestionBank[mCurrentIndex].isAnswerTrue();
        ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        int messageResId;

        if(answerIsCorrect){
            messageResId = R.string.correct_toast;
            mProgressBar.incrementProgressBy(1);
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    /**
     * This onCreate method sets up the previous and next buttons with functionality.
     *
     * @see QuizActivity#updateQuestion()
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();

        Button trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TrueFalseQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(true);
                checkAnswer();
            }
        });

        Button falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TrueFalseQuestion) mQuestionBank[mCurrentIndex]).setUserAnswer(false);
                checkAnswer();
            }
        });


        ImageButton nextButton = (ImageButton) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        ImageButton prevButton = (ImageButton) findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = mCurrentIndex == 0 ? (mQuestionBank.length - 1) : mCurrentIndex - 1;
                updateQuestion();
            }
        });
    }

}
