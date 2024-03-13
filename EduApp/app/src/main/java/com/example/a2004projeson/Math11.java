package com.example.a2004projeson;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.intellij.lang.annotations.Language;
import org.w3c.dom.Text;

import java.util.Random;

public class Math11 extends AppCompatActivity {
    private TextView textViewTutorial;
    private Button buttonStart;

    int score = 0;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private TextView textViewEquation;
    private Button buttonOption1;
    private Button buttonOption2;
    private Button buttonOption3;
    private Button buttonOption4;
    private TextView textViewResult;

    private TextView well_done;

    private Button checkButton;

    private int correctAnswer;
    private boolean gameStarted = false;
    private Button selectedButton;
    private int questionCount = 0;
    private int correctCount = 0;

    private ImageView imageView7;

    private static final int MAX_QUESTIONS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        CurrentName = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math11);

        textViewTutorial = findViewById(R.id.textViewTutorial);
        buttonStart = findViewById(R.id.buttonStart);
        textViewEquation = findViewById(R.id.textViewEquation);
        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonOption4 = findViewById(R.id.buttonOption4);
        textViewResult = findViewById(R.id.textViewResult);
        checkButton = findViewById(R.id.checkButton);
        imageView7 = findViewById(R.id.imageView7);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption(buttonOption1);
            }
        });

        buttonOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption(buttonOption2);
            }
        });

        buttonOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption(buttonOption3);
            }
        });

        buttonOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectOption(buttonOption4);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                userRef.child(CurrentName).child("multiplication").setValue(score);
            }
        });

        showTutorial();
    }

    private void showTutorial() {
        textViewTutorial.setVisibility(View.VISIBLE);
        buttonStart.setVisibility(View.VISIBLE);
        textViewEquation.setVisibility(View.GONE);
        buttonOption1.setVisibility(View.GONE);
        buttonOption2.setVisibility(View.GONE);
        buttonOption3.setVisibility(View.GONE);
        buttonOption4.setVisibility(View.GONE);
        textViewResult.setVisibility(View.GONE);
        checkButton.setVisibility(View.GONE);
        imageView7.setVisibility(View.VISIBLE);
    }

    private void startGame() {
        textViewTutorial.setVisibility(View.GONE);
        buttonStart.setVisibility(View.GONE);
        textViewEquation.setVisibility(View.VISIBLE);
        imageView7.setVisibility(View.GONE);
        buttonOption1.setVisibility(View.VISIBLE);
        buttonOption2.setVisibility(View.VISIBLE);
        buttonOption3.setVisibility(View.VISIBLE);
        buttonOption4.setVisibility(View.VISIBLE);
        textViewResult.setVisibility(View.VISIBLE);
        checkButton.setVisibility(View.VISIBLE);
        gameStarted = true;
        questionCount = 0;
        correctCount = 0;
        generateEquation();
    }

    private void generateEquation() {
        if (questionCount >= MAX_QUESTIONS) {
            // Game finished
            gameStarted = false;
            textViewResult.setText("");
            showTutorial();

//            TextView well_done = (TextView) findViewById(R.string.well_done);

//            well_done.setText("qweqweqwe");
//            String well_done = String.valueOf((R.string.well_done));


            if (correctCount >= 5) {
//                Toast.makeText(Math11.this,"Well done! Congratulations!" , Toast.LENGTH_LONG).show();
                Toast.makeText(Math11.this, R.string.well_done , Toast.LENGTH_LONG).show();
            } else {
//                Toast.makeText(this, "You should practice more. Please try again. Your correct answers : " + correctCount, Toast.LENGTH_LONG).show();
                Toast.makeText(Math11.this, R.string.try_again_toast  , Toast.LENGTH_LONG).show();
            }
            return;
        }

        questionCount++;
        Random random = new Random();
        int operand1 = random.nextInt(10) + 1; // Random number between 1 and 10
        int operand2 = random.nextInt(10) + 1; // Random number between 1 and 10
        correctAnswer = operand1 * operand2;

        textViewEquation.setText(operand1 + " * " + operand2 + " = ?");

        // Generate random options for buttons
        int[] options = generateRandomOptions(correctAnswer);

        buttonOption1.setText(String.valueOf(options[0]));
        buttonOption2.setText(String.valueOf(options[1]));
        buttonOption3.setText(String.valueOf(options[2]));
        buttonOption4.setText(String.valueOf(options[3]));

        // Reset button colors
        resetButtonColors();
    }

    private int[] generateRandomOptions(int correctAnswer) {
        Random random = new Random();
        int[] options = new int[4];
        options[0] = correctAnswer;
        options[1] = generateIncorrectOption(correctAnswer, random);
        options[2] = generateIncorrectOption(correctAnswer, random);
        options[3] = generateIncorrectOption(correctAnswer, random);

        // Shuffle the options array
        for (int i = options.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = options[i];
            options[i] = options[j];
            options[j] = temp;
        }

        return options;
    }

    private int generateIncorrectOption(int correctAnswer, Random random) {
        int incorrectOption;
        do {
            incorrectOption = random.nextInt(correctAnswer * 2) + 1; // Random number between 1 and (correctAnswer * 2)
        } while (incorrectOption == correctAnswer);

        return incorrectOption;
    }

    private void selectOption(Button optionButton) {
        if (!gameStarted) {
            return; // Ignore button clicks before the game starts
        }

        resetButtonColors();
        selectedButton = optionButton;
        selectedButton.setBackgroundColor(Color.LTGRAY);
    }

    private void resetButtonColors() {
        buttonOption1.setBackgroundColor(Color.GRAY);
        buttonOption2.setBackgroundColor(Color.GRAY);
        buttonOption3.setBackgroundColor(Color.GRAY);
        buttonOption4.setBackgroundColor(Color.GRAY);
    }

    private void checkAnswer() {
        if (selectedButton == null) {
            return; // No option selected
        }

        int selectedAnswer = Integer.parseInt(selectedButton.getText().toString());

        if (selectedAnswer == correctAnswer) {
            score += 30;
            textViewResult.setText(R.string.correct_answer);
//            selectedButton.setBackgroundColor(Color.GREEN);
            correctCount++;
        } else {
            score -= 20;
            textViewResult.setText(R.string.incorrect_answer);
//            selectedButton.setBackgroundColor(Color.RED);
        }

        generateEquation();
    }
}
