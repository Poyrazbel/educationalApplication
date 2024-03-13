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


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Math7 extends AppCompatActivity {
    private TextView textViewDigits;
    private LinearLayout tutorialLayout7;
    private Button buttonStart7;
    private LinearLayout inputLayout;
    private EditText editTextInput;
    private Button buttonCheck;
    private Button buttonTryAgain;

    private Button button16;
    private TextView textViewResult;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private Handler handler;
    private boolean isAnswerCorrect;
    private int correctAnswersCount;
    int score = 0;
    private List<Integer> digitCounts;
    private int currentDigitIndex;
    private int targetNumber;

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math7);
        textViewDigits = findViewById(R.id.textViewDigits);
        tutorialLayout7 = findViewById(R.id.tutorialLayout7);
        buttonStart7 = findViewById(R.id.buttonStart7);
        inputLayout = findViewById(R.id.inputLayout);
        editTextInput = findViewById(R.id.editTextInput);
        buttonCheck = findViewById(R.id.buttonCheck);
        buttonTryAgain = findViewById(R.id.buttonTryAgain);
        button16 = findViewById(R.id.button16);
        textViewResult = findViewById(R.id.textViewResult);
        imageView = findViewById(R.id.imageView);

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
                userRef.child(CurrentName).child("score_digits0").setValue(score);
            }
        });

        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryAgain();
            }
        });

        button16.setOnClickListener(new View.OnClickListener() {
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
        imageView.setVisibility(View.GONE);

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
        if (currentDigitIndex >= digitCounts.size()) {
            // No more questions, show final result
            showFinalResult();
            return;
        }

        int numDigits = digitCounts.get(currentDigitIndex);
        textViewDigits.setText(String.valueOf(targetNumber));
        textViewDigits.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewDigits.setVisibility(View.INVISIBLE);
                showInputSection();
                button16.setVisibility(View.INVISIBLE);
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

        try {
            int userAnswer = Integer.parseInt(userInput);
            if (userAnswer == targetNumber) {
                textViewResult.setText(R.string.correct_answer);
                score += 30;
                isAnswerCorrect = true;
                hideInputSection();
                correctAnswersCount++;
            } else {
                textViewResult.setText(R.string.incorrect_answer);
                score -= 10;
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
                button16.setVisibility(View.INVISIBLE);
                hideInputSection();
                return;
            }
            buttonTryAgain.setVisibility(View.INVISIBLE);
            button16.setVisibility(View.INVISIBLE);
            currentDigitIndex++;
            generateTargetNumber();
            displayDigits();
        } else {
            if (correctAnswersCount < 8) {
                buttonTryAgain.setVisibility(View.VISIBLE);
                button16.setVisibility(View.VISIBLE);
            } else {
                textViewResult.setText(getString());
                buttonTryAgain.setVisibility(View.INVISIBLE);
                button16.setVisibility(View.INVISIBLE);

            }
        }
    }

    @NonNull
    private String getString() {
        return "You did a great job!";
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
