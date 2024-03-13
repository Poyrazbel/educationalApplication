package com.example.a2004projeson;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class fourthMonthActivity extends AppCompatActivity {
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;

    private String[] question = {"What is the first month of the year?", "Next month is March. What is this month?",
            "Last month was February. What is this month?", "What is the fourth month of the year?",
            "What is the fifth month of the year?", "This month is May. What is the next month?",
            "What is the seventh month of the year?", "What is the eighth month of the year?",
            "What month comes after August?", "Last month was September. What is this month?",
            "Next month is December. What is this month?","This month is November. What is next month?",};

    private TextView qText;
    private ImageView dora;
    private ImageView win;
    private TextView score_p;
    private Button m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12;

    private Button buttonN,buttonC,buttonR;
    Random random = new Random();
    int question_num;

    int index = 0;
    int point = 0;
    int sel_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_month);
        qText = findViewById(R.id.queText);

        question_num = random.nextInt(12);
        qText.setText(question[question_num]);

        m1 = findViewById(R.id.januaryB); m2 = findViewById(R.id.februaryB);
        m3 = findViewById(R.id.marchB); m4 = findViewById(R.id.aprilB);
        m5 = findViewById(R.id.mayB); m6 = findViewById(R.id.juneB);
        m7 = findViewById(R.id.julyB); m8 = findViewById(R.id.augustB);
        m9 = findViewById(R.id.septemberB); m10 = findViewById(R.id.octoberB);
        m11 = findViewById(R.id.novemberB); m12 = findViewById(R.id.decemberB);

        buttonN = findViewById(R.id.next_button); buttonC = findViewById(R.id.check_button);
        buttonR = findViewById(R.id.reset);

        dora = findViewById(R.id.character);
        win = findViewById(R.id.congratulations_img);
        score_p = findViewById(R.id.score_num);




        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 0;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m1.getX()-doraX).
                        translationYBy(m1.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 1;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m2.getX()-doraX).
                        translationYBy(m2.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 2;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m3.getX()-doraX).
                        translationYBy(m3.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 3;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m4.getX()-doraX).
                        translationYBy(m4.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 4;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m5.getX()-doraX).
                        translationYBy(m5.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 5;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m6.getX()-doraX).
                        translationYBy(m6.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 6;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m7.getX()-doraX).
                        translationYBy(m7.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 7;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m8.getX()-doraX).
                        translationYBy(m8.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 8;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m9.getX()-doraX).
                        translationYBy(m9.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 9;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m10.getX()-doraX).
                        translationYBy(m10.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 10;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m11.getX()-doraX).
                        translationYBy(m11.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num = 11;

                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];


                dora.animate().translationXBy(m12.getX()-doraX).
                        translationYBy(m12.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setVisibility(View.GONE);
                buttonN.setVisibility(View.VISIBLE);
                index++;

                if(sel_num == question_num){
                    win.setVisibility(View.VISIBLE);
                    point += 34;
                    score_p.setText(Integer.toString(point));
                }else {
                    point -= 23;
                    score_p.setText(Integer.toString(point));
                }
            }
        });

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] imageLocation = new int[2];
                dora.getLocationOnScreen(imageLocation);
                int doraX = imageLocation[0];
                int doraY = imageLocation[1];
                win.setVisibility(View.GONE);

                dora.animate().translationXBy(buttonR.getX()-doraX).
                        translationYBy(buttonR.getY()-doraY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());



                question_num = random.nextInt(12);
                qText.setText(question[question_num]);

                buttonC.setVisibility(View.VISIBLE);
                buttonN.setVisibility(View.GONE);

                if(index == 6){
                    userRef.child(CurrentName).child("score_months").setValue(point);
                    Intent intent = new Intent(fourthMonthActivity.this, Time_menu.class);
                    intent.putExtra("username",currentname);
                    startActivity(intent);
                }

            }
        });
    }
}