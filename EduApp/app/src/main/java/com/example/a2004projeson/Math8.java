package com.example.a2004projeson;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Math8 extends AppCompatActivity {
    private TextView textViewDigits;
    private LinearLayout tutorialLayout7;
    private Button buttonStart7;
    private LinearLayout inputLayout;
    private EditText editTextInput;
    private Button buttonCheck;
    private Button buttonTryAgain;

    private Button buttonSkip;

    int score = 0;

    private TextView textViewResult;

    private Handler handler;
    private boolean isAnswerCorrect;
    private int correctAnswersCount;

    private List<Integer> digitCounts;
    private int currentDigitIndex;
    private int targetNumber;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        CurrentName = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math8);

        textViewDigits = findViewById(R.id.textViewDigits);
        tutorialLayout7 = findViewById(R.id.tutorialLayout7);
        buttonStart7 = findViewById(R.id.buttonStart7);
        inputLayout = findViewById(R.id.inputLayout);
        editTextInput = findViewById(R.id.editTextInput);
        buttonCheck = findViewById(R.id.buttonCheck);
        buttonTryAgain = findViewById(R.id.buttonTryAgain);
        textViewResult = findViewById(R.id.textViewResult);
        buttonSkip = findViewById(R.id.buttonSkip);
        imageView2 = findViewById(R.id.imageView2);

        handler = new Handler();

        buttonStart7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
                userRef.child(CurrentName).child("score_digits1").setValue(score);
            }
        });

        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryAgain();
            }
        });
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skipQuestion();
            }
        });

        digitCounts = new ArrayList<>();
        digitCounts.add(3); // 2 times 3-digit numbers
        digitCounts.add(3); // 2 times 3-digit numbers
        digitCounts.add(4); // 3 times 4-digit numbers
        digitCounts.add(4); // 3 times 4-digit numbers
        digitCounts.add(4); // 3 times 4-digit numbers
        digitCounts.add(5); // 3 times 5-digit numbers
        digitCounts.add(5); // 3 times 5-digit numbers
        digitCounts.add(5); // 3 times 5-digit numbers
        currentDigitIndex = 0;
        correctAnswersCount = 0;
    }

    private void startActivity() {
        tutorialLayout7.setVisibility(View.GONE);
        imageView2.setVisibility(View.GONE);
        generateTargetNumber();
        displayDigits();
    }
    private void skipQuestion() {
        currentDigitIndex++;
        if (currentDigitIndex >= digitCounts.size()) {
            // No more questions, show final result
            showFinalResult();
        } else {
            generateTargetNumber();
            displayDigits();
            inputLayout.setVisibility(View.INVISIBLE);
        }
    }

    private void generateTargetNumber() {
        int numDigits = digitCounts.get(currentDigitIndex);
        Random random = new Random();
        int min = (int) java.lang.Math.pow(10, numDigits - 1);
        int max = (int) java.lang.Math.pow(10, numDigits) - 1;
        targetNumber = random.nextInt(max - min + 1) + min;
    }

    private void displayDigits() {
        int numDigits = digitCounts.get(currentDigitIndex);
        textViewDigits.setText(String.valueOf(targetNumber));
        textViewDigits.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewDigits.setVisibility(View.INVISIBLE);
                showInputSection();
                buttonSkip.setVisibility(View.INVISIBLE);
                buttonTryAgain.setVisibility(View.INVISIBLE);

            }
        }, 2500); // Display the number for 2.5 seconds
    }

    private void showInputSection() {
        inputLayout.setVisibility(View.VISIBLE);
    }

    private void hideInputSection() {
        inputLayout.setVisibility(View.INVISIBLE);
    }

    private void checkAnswer() {
        String userInput = editTextInput.getText().toString().trim();

        if (userInput.isEmpty()) {
            textViewResult.setText(R.string.pls_enter_your_answer);
            return;
        }

        StringBuilder userInputBuilder = new StringBuilder(userInput);
        userInputBuilder.reverse(); // Reverse the user input
        String reversedUserInput = userInputBuilder.toString();

        try {
            int userAnswer = Integer.parseInt(reversedUserInput);
            if (userAnswer == targetNumber) {
                score += 30;
                textViewResult.setText(R.string.correct_answer);
                isAnswerCorrect = true;
                hideInputSection();
                correctAnswersCount++;
            } else {
                score -= 20;
                textViewResult.setText(R.string.incorrect_answer);
                isAnswerCorrect = false;
            }
            editTextInput.getText().clear();
        } catch (NumberFormatException e) {
            textViewResult.setText(R.string.invalid_input);
        }

        if (isAnswerCorrect) {
            if (correctAnswersCount >= 8) {
                textViewResult.setText(R.string.great_job);
                buttonTryAgain.setVisibility(View.INVISIBLE);
                buttonSkip.setVisibility(View.INVISIBLE);
                hideInputSection();
                return;
            }
            buttonTryAgain.setVisibility(View.GONE);
            currentDigitIndex++;
            generateTargetNumber();
            displayDigits();
        } else {
            if (correctAnswersCount < 8) {
                buttonTryAgain.setVisibility(View.VISIBLE);
                buttonSkip.setVisibility(View.VISIBLE);

            } else {
                textViewResult.setText(R.string.great_job);
                buttonTryAgain.setVisibility(View.GONE);
                buttonSkip.setVisibility(View.GONE);
            }
        }
    }







    private void updateResultText() {
        if (isAnswerCorrect) {
            textViewResult.setText(R.string.correct_answer);
//            textViewResult.setTextColor(ContextCompat.getColor(this, R.color.colorCorrect));
        } else {
            textViewResult.setText(R.string.incorrect_answer);
//            textViewResult.setTextColor(ContextCompat.getColor(this, R.color.colorIncorrect));
        }
    }


    private void showTryAgainButton() {
        buttonTryAgain.setVisibility(View.VISIBLE);
    }

    private void tryAgain() {
        buttonTryAgain.setVisibility(View.GONE);
        buttonSkip.setVisibility(View.GONE);
        hideInputSection();
        editTextInput.getText().clear();
        textViewResult.setText("");
        displayDigits();
    }

    private void showFinalResult() {
        hideInputSection();
        textViewResult.setText(R.string.congrats);
//        textViewResult.setTextColor(getResources().getColor(R.color.colorCorrect));
    }
}