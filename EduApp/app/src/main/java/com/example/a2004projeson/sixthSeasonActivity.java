package com.example.a2004projeson;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class sixthSeasonActivity extends AppCompatActivity {

    private String[] question = {"What season is February in?","What season is September in?","What season is July in?",
            "What season is October in?","What season is May in?","What is the hottest season of the year?",
            "What season do flowers bloom?","In what season is a snowman made?","In which season do the leaves of the trees turn yellow?"};

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private TextView qText;
    private ImageView spiderman;
    private Button winter,spring,summer,autumn;
    private Button buttonN,buttonC,buttonR;

    private ImageView win;
    private TextView score_p;



    Random random = new Random();
    int question_num;

    int sel_num1 = 100;
    int sel_num2 = 100;
    int sel_num3 = 100;


    int index = 0;
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_season);

        qText =findViewById(R.id.question);
        spiderman = findViewById(R.id.spiderman);

        winter = findViewById(R.id.winterB);spring = findViewById(R.id.springB);
        summer = findViewById(R.id.summerB);autumn = findViewById(R.id.autumnB);

        buttonC = findViewById(R.id.check_button);buttonN = findViewById(R.id.next_button);
        buttonR = findViewById(R.id.reset);



        score_p = findViewById(R.id.score_num);
        win = findViewById(R.id.win_img);


        question_num = random.nextInt(9);
        qText.setText(question[question_num]);



        winter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num1 = 0;
                sel_num2 = 7;


                int[] imageLocation = new int[2];
                spiderman.getLocationOnScreen(imageLocation);
                int spiderX = imageLocation[0];
                int spiderY = imageLocation[1];


                spiderman.animate().translationXBy(winter.getX()-spiderX).
                        translationYBy(winter.getY()-spiderY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num1 = 4;
                sel_num2 = 6;

                int[] imageLocation = new int[2];
                spiderman.getLocationOnScreen(imageLocation);
                int spiderX = imageLocation[0];
                int spiderY = imageLocation[1];


                spiderman.animate().translationXBy(spring.getX()-spiderX).
                        translationYBy(spring.getY()-spiderY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        summer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num1 = 2;
                sel_num2 = 5;

                int[] imageLocation = new int[2];
                spiderman.getLocationOnScreen(imageLocation);
                int spiderX = imageLocation[0];
                int spiderY = imageLocation[1];


                spiderman.animate().translationXBy(summer.getX()-spiderX).
                        translationYBy(summer.getY()-spiderY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        autumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sel_num1 = 1;
                sel_num2 = 3;
                sel_num3 = 8;

                int[] imageLocation = new int[2];
                spiderman.getLocationOnScreen(imageLocation);
                int spiderX = imageLocation[0];
                int spiderY = imageLocation[1];


                spiderman.animate().translationXBy(autumn.getX()-spiderX).
                        translationYBy(autumn.getY()-spiderY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonC.setVisibility(View.GONE);
                buttonN.setVisibility(View.VISIBLE);
                index++;

                if(sel_num1 == question_num || sel_num2 == question_num || sel_num3 == question_num){
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
                spiderman.getLocationOnScreen(imageLocation);
                int spiderX = imageLocation[0];
                int spiderY = imageLocation[1];
                win.setVisibility(View.GONE);

                spiderman.animate().translationXBy(buttonR.getX()-spiderX).
                        translationYBy(buttonR.getY()-spiderY)
                        .scaleX(1).scaleY(1).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());



                question_num = random.nextInt(9);
                qText.setText(question[question_num]);

                buttonC.setVisibility(View.VISIBLE);
                buttonN.setVisibility(View.GONE);

                if(index == 6){
                    userRef.child(CurrentName).child("score_seasons").setValue(point);
                    Intent intent = new Intent(sixthSeasonActivity.this, Time_menu.class);
                    intent.putExtra("username",currentname);
                    startActivity(intent);
                }

            }
        });



    }
}