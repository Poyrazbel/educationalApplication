package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Time_menu extends AppCompatActivity {
    private Button button22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_menu);
        ImageView clock = findViewById(R.id.clock);
        ImageView week = findViewById(R.id.week);
        ImageView month = findViewById(R.id.month);
        ImageView season = findViewById(R.id.season);
        button22 = findViewById(R.id.button22);

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), firstClockActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), firstWeekActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), firstMonthActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        season.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), firstSeasonActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Menu.class);
                it.putExtra("username",currentname);
                startActivity(it);
            }
        });
    }

}