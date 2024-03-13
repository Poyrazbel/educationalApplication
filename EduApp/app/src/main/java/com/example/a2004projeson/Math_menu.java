package com.example.a2004projeson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Math_menu extends AppCompatActivity {

    private Button button20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_menu);

        button20 = findViewById(R.id.button20);
        ImageView imageView = findViewById(R.id.math7);
        ImageView imageView2 = findViewById(R.id.math8);
        ImageView imageView3 = findViewById(R.id.math11);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Math8.class);
                it.putExtra("username", currentname);
                startActivity(it);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Math7.class);
                it.putExtra("username", currentname);
                startActivity(it);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Math11.class);
                it.putExtra("username", currentname);
                startActivity(it);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getBaseContext(), Menu.class);
                it.putExtra("username", currentname);
                startActivity(it);
            }
        });
    }
}
