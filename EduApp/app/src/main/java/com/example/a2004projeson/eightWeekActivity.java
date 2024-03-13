package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class eightWeekActivity extends AppCompatActivity {


    private Button buttonC;
    private Button buttonW1;
    private Button buttonW2;
    private Button buttonW3;
    private Button buttonCheck;
    private Button buttonN;
    private TextView textView;

    int select_num;

    private boolean answer = false;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_week);
        textView = findViewById(R.id.score_num);
        point = getIntent().getIntExtra("score_p", 1);
        textView.setText(Integer.toString(point));
        buttonC = findViewById(R.id.correct_answer);
        buttonW1 = findViewById(R.id.wrong_answer1);
        buttonW2 = findViewById(R.id.wrong_answer2);
        buttonW3 = findViewById(R.id.wrong_answer3);
        buttonN = findViewById(R.id.next_button_5);
        buttonCheck = findViewById(R.id.check_button);


        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.select));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));

                answer = true;
            }
        });

        buttonW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.select));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                answer = false;
                select_num = 1;
            }
        });

        buttonW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.select));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                answer = false;
                select_num = 2;
            }
        });

        buttonW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.select));
                answer = false;
                select_num = 3;
            }
        });

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCheck.setVisibility(view.GONE);
                buttonN.setVisibility(view.VISIBLE);
                buttonC.setEnabled(false);
                buttonW1.setEnabled(false);
                buttonW2.setEnabled(false);
                buttonW3.setEnabled(false);

                if (answer) {
                    buttonC.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.green));
                    point += 34;
                    textView.setText(Integer.toString(point));
                } else {
                    point -= 23;
                    switch (select_num) {
                        case 1:
                            buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                        case 2:
                            buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                        case 3:
                            buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(eightWeekActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                    }
                }
            }
        });

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(eightWeekActivity.this, ninthWeekActivity.class);
                intent.putExtra("score_p", point);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });

    }
}