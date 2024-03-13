package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondWeekActivity extends AppCompatActivity {

    private Button buttonN;
    private Button buttonB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_week);
        buttonN = findViewById(R.id.next_button_1);
        buttonB = findViewById(R.id.back_button_1);

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondWeekActivity.this, thirdWeekActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondWeekActivity.this, firstWeekActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
    }
}