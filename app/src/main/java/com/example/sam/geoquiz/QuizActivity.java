package com.example.sam.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    Button mMcButtonOne = (Button) findViewById(R.id.mc_button_one);
    Button mMcButtonTwo = (Button) findViewById(R.id.mc_button_two);
    Button mMcButtonThree = (Button) findViewById(R.id.mc_button_three);
    Button mMcButtonFour = (Button) findViewById(R.id.mc_button_four);

    private Question[] mQuestionBank = new Question[] {
            new TrueFalseQuestion(R.string.question_oceans, true),
            new TrueFalseQuestion(R.string.question_mideast, false),
            new TrueFalseQuestion(R.string.question_africa, false),
            new TrueFalseQuestion(R.string.question_americas, true),
            new TrueFalseQuestion(R.string.question_asia, true),
            new MultipleChoiceQuestion(R.string.question_beer, new int[]{R.string.answer_beer_one,
                    R.string.answer_beer_two,R.string.answer_beer_three,R.string.answer_beer_four},1)
    };

    private int mCurrentIndex = 0;

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
        } else if (mQuestionBank[mCurrentIndex] instanceof MultipleChoiceQuestion) {
            findViewById(R.id.true_false_view).setVisibility(View.GONE);
            findViewById(R.id.mc_question_view).setVisibility(View.GONE);
            findViewById(R.id.fill_in_question_layout).setVisibility(View.VISIBLE);
        }
    }

    private void checkAnswer() {
        boolean answerIsCorrect =  mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId;

        if(answerIsCorrect){
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

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
