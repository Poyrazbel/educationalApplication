package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstSeasonActivity extends AppCompatActivity {

    private Button buttonN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_season);
        buttonN = findViewById(R.id.next_button);

        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(firstSeasonActivity.this, secondSeasonActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
    }
}