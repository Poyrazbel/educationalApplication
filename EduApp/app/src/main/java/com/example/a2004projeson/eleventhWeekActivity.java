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

import java.sql.Time;

public class eleventhWeekActivity extends AppCompatActivity {

    private Button monday;
    private Button tuesday;
    private Button wednesday;
    private Button thursday;
    private Button friday;
    private Button saturday;
    private Button sunday;
    private Button buttonC;
    private Button buttonN;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private TextView MONDAY;
    private TextView TUESDAY;
    private TextView WEDNESDAY;
    private TextView THURSDAY;
    private TextView FIRDAY;
    private TextView SATURDAY;
    private TextView SUNDAY;
    private TextView textView;

    int point;
    int day = 1;
    int day_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleventh_week);
        monday = findViewById(R.id.monday_b);
        tuesday = findViewById(R.id.tuesday_b);
        wednesday = findViewById(R.id.wednesday_b);
        thursday = findViewById(R.id.thursday_b);
        friday = findViewById(R.id.friday_b);
        saturday = findViewById(R.id.saturday_b);
        sunday = findViewById(R.id.sunday_b);
        buttonC = findViewById(R.id.check_button);
        buttonN = findViewById(R.id.next_button_5);

        MONDAY = findViewById(R.id.Mondayx);
        TUESDAY = findViewById(R.id.Tuesdayx);
        WEDNESDAY = findViewById(R.id.Wednesdayx);
        THURSDAY = findViewById(R.id.Thursdayx);
        FIRDAY = findViewById(R.id.Fridayx);
        SATURDAY = findViewById(R.id.Saturdayx);
        SUNDAY = findViewById(R.id.Sundayx);

        textView = findViewById(R.id.score_num);
        point = getIntent().getIntExtra("score_p", 1);
        textView.setText(Integer.toString(point));


        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 1;
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 2;
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 3;
            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 4;
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 5;
            }
        });

        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                day_selected = 6;
            }
        });

        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.light_brown));
                sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.select));
                day_selected = 7;
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                monday.setEnabled(false);
                tuesday.setEnabled(false);
                wednesday.setEnabled(false);
                thursday.setEnabled(false);
                friday.setEnabled(false);
                saturday.setEnabled(false);
                sunday.setEnabled(false);
                buttonC.setVisibility(view.GONE);
                buttonN.setVisibility(view.VISIBLE);


                if(day == day_selected){
                    switch (day){
                        case 1:
                            monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));MONDAY.setVisibility(view.VISIBLE);break;
                        case 2:
                            tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));TUESDAY.setVisibility(view.VISIBLE);break;
                        case 3:
                            wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));WEDNESDAY.setVisibility(view.VISIBLE);break;
                        case 4:
                            thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));THURSDAY.setVisibility(view.VISIBLE);break;
                        case 5:
                            friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));FIRDAY.setVisibility(view.VISIBLE);break;
                        case 6:
                            saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));SATURDAY.setVisibility(view.VISIBLE);break;
                        case 7:
                            sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.green));SUNDAY.setVisibility(view.VISIBLE);break;
                    }
                    point +=34;
                    textView.setText(Integer.toString(point));
                    day++;
                }else {
                    switch (day_selected){
                        case 1:
                            monday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 2:
                            tuesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 3:
                            wednesday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 4:
                            thursday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 5:
                            friday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 6:
                            saturday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                        case 7:
                            sunday.setBackgroundTintList(ContextCompat.getColorStateList(eleventhWeekActivity.this, R.color.red));break;
                    }
                    point -= 23;
                    textView.setText(Integer.toString(point));
                }
            }
        });

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day<=7) {
                    monday.setEnabled(true);
                    tuesday.setEnabled(true);
                    wednesday.setEnabled(true);
                    thursday.setEnabled(true);
                    friday.setEnabled(true);
                    saturday.setEnabled(true);
                    sunday.setEnabled(true);

                    buttonC.setVisibility(view.VISIBLE);
                    buttonN.setVisibility(view.GONE);
                }else{
                    userRef.child(CurrentName).child("score_Weeks").setValue(point);
                    Intent intent = new Intent(eleventhWeekActivity.this, Time_menu.class);
                    intent.putExtra("username",currentname);
                    startActivity(intent);
                }
            }
        });


    }
}