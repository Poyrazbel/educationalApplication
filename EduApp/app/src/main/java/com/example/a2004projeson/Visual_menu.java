package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Visual_menu extends AppCompatActivity {

    private Button button21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_menu);

        button21 = findViewById(R.id.button21);
        ImageView imageView = findViewById(R.id.spelling_activity);
        ImageView imageView2 = findViewById(R.id.directions_activity);
        ImageView imageView3 = findViewById(R.id.reading_activity);
        ImageView imageView4 = findViewById(R.id.similarpictures_acitivity);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpellingActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DirectionsActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReadingActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), similarPicturesActivity.class);
                intent.putExtra("username",currentname);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Menu.class);
                it.putExtra("username",currentname);
                startActivity(it);
            }
        });
    }
}