package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ninthClockActivity extends AppCompatActivity {

    private Button buttonC;
    private Button buttonW1;
    private Button buttonW2;
    private Button buttonW3;
    private Button buttonCheck;
    private Button buttonN;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private TextView textView;

    int select_num;

    private boolean answer = false;

    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_clock);
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
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.select));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));

                answer = true;
            }
        });

        buttonW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.select));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                answer = false;
                select_num = 1;
            }
        });

        buttonW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.select));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                answer = false;
                select_num = 2;
            }
        });

        buttonW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.light_brown));
                buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.select));
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
                    buttonC.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.green));
                    point += 34;
                    textView.setText(Integer.toString(point));
                } else {
                    point -= 23;
                    switch (select_num) {
                        case 1:
                            buttonW1.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                        case 2:
                            buttonW2.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                        case 3:
                            buttonW3.setBackgroundTintList(ContextCompat.getColorStateList(ninthClockActivity.this, R.color.red));
                            textView.setText(Integer.toString(point));
                            break;
                    }
                }
            }
        });

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRef.child(CurrentName).child("score_clock").setValue(point);
                Intent intent = new Intent(ninthClockActivity.this, Time_menu.class);
                intent.putExtra("score_p", point);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
    }
}