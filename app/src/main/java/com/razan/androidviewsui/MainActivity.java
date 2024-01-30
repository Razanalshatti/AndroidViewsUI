package com.razan.androidviewsui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionView, correctView, wrongView, scoreView;
    private Button trueButton, falseButton, nextButton;

    private ArrayList<String> question;
    private ArrayList<Boolean> answers;
    private int currentIndex = 0;

    int grade = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionView = findViewById(R.id.questionView);
        correctView = findViewById(R.id.correctView);
        wrongView = findViewById(R.id.WrongView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.nextButton);
        scoreView = findViewById(R.id.scoreView);


        question = new ArrayList<>();
        answers = new ArrayList<>();


        question.add("Sharks are mammals.");
        answers.add(false);

        question.add("Bats are blind.");
        answers.add(false);

        question.add("The most common blood type is 0- negative.");
        answers.add(true);

        displayQuestion();

        trueButton.setOnClickListener(view -> checkAnswer(true));
        falseButton.setOnClickListener(view -> checkAnswer(false));
        nextButton.setOnClickListener(view -> nextQuestion());
    }

    private void displayQuestion() {
        questionView.setText(question.get(currentIndex));

        scoreView.setText(String.valueOf(grade));

        correctView.setVisibility(View.INVISIBLE);
        wrongView.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers.get(currentIndex);

        if (userAnswer == correctAnswer) {

            correctView.setVisibility(View.VISIBLE);
            wrongView.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.VISIBLE);

            gradecalc();
        } else {

            correctView.setVisibility(View.INVISIBLE);
            wrongView.setVisibility(View.VISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
        }
    }

    public void gradecalc() {
        grade++;
        scoreView.setText(String.valueOf(grade));
    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex < question.size()) {
            displayQuestion();
        } else {

        }
    }
}