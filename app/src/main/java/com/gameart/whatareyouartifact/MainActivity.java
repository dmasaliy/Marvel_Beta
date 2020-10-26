package com.gameart.whatareyouartifact;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textQuestion;

    private String rightAnswer;
    private int rightQuizCount = 1;

    Button buttonAnswe1;
    Button buttonAnswe2;

    ArrayList<ArrayList<String>> triviaQuiz = new ArrayList<>();

    String data[][] = {
            {"Choose a band whose music you like.", "The Beatles", "Queen"},
            {"What do you animal associate yourself with?", "Dog", "Cat"},
            {"Where would you hide a large amount of money?", "In the pit", "In the mattress"},
            {"Choose the word you like best", "Vinil", "Corruption"},
            {"Childhood favorite treat", "Chips", "Ice cream"},
            {"Which of these personalities will you entrust your secret to?", "Barack Obama", "Stephen Hawking"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        for (int i = 0; i < data.length; i++) {
            ArrayList<String> array = new ArrayList<>();
            array.add(data[i][0]);
            array.add(data[i][1]);
            array.add(data[i][2]);

            triviaQuiz.add(array);
        }

        textQuestion = findViewById(R.id.textQuestion);

        buttonAnswe1 = findViewById(R.id.buttonAnswer1);
        buttonAnswe2 = findViewById(R.id.buttonAnswer2);

        buttonAnswe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(view);
            }
        });
        buttonAnswe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(view);
            }
        });

        nextQuestion();

    }

    private void nextQuestion() {
        Random random = new Random();
        int randomNum = random.nextInt(triviaQuiz.size());

        ArrayList<String> quiz = triviaQuiz.get(randomNum);

        rightAnswer = quiz.get(1);

        textQuestion.setText(quiz.get(0));

        buttonAnswe1.setText(quiz.get(1));
        buttonAnswe2.setText(quiz.get(2));
    }

    public void checkAnswer(View view){

        if(rightQuizCount == 6) {
            Intent intent = new Intent(MainActivity.this, Whose.class);
            startActivity(intent);
        }else {
            rightQuizCount++;
            nextQuestion();
        }
    }

}