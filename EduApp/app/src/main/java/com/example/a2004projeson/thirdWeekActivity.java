package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thirdWeekActivity extends AppCompatActivity {
    private Button buttonB;
    private Button buttonN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_week);
        buttonB = findViewById(R.id.back_button_1);
        buttonN = findViewById(R.id.next_button_1);

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thirdWeekActivity.this, fourthWeekActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });


        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thirdWeekActivity.this, secondWeekActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
    }
}