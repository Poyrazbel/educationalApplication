package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;


public class DirectionsActivity extends AppCompatActivity {

    private int last_event;

    static int points;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    private TextView score,correcto;
    private ImageView above,behind,below,between,infrontof,inside,left,nexto,on,right;

    private int event_number = 0;
    private String CorrectAnswer;
    private Button b1,b2,b3,b4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        Toast.makeText(this,currentname,Toast.LENGTH_SHORT);
        above = findViewById(R.id.above);
        behind = findViewById(R.id.behind);
        below = findViewById(R.id.below);
        between = findViewById(R.id.between);
        infrontof = findViewById(R.id.infrontof);
        inside = findViewById(R.id.inside);
        left = findViewById(R.id.left);
        nexto = findViewById(R.id.nexto);
        on = findViewById(R.id.on);
        right = findViewById(R.id.right);
        b1 = findViewById(R.id.button16);
        b2 = findViewById(R.id.button17);
        b3 = findViewById(R.id.button18);
        b4 = findViewById(R.id.button23);
        score = findViewById(R.id.Score);
        correcto = findViewById(R.id.show_text);
        ImageView []directions = new ImageView[]{above,behind,below,between,infrontof,inside,left,nexto,on,right};
        String[] words = new String[]{"above","behind","below","between","infrontof","inside","left","nexto","on","right"};
        Button[] buttons = new Button[]{b1,b2,b3};
        event(directions,buttons,words);
        Toast correct = Toast.makeText(this,"CORRECT!",Toast.LENGTH_SHORT);
        Toast wrong = Toast.makeText(this,"WRONG!",Toast.LENGTH_SHORT);
        correcto.setVisibility(View.INVISIBLE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1.getText().toString().equals(CorrectAnswer)){
                    correct.show();
                    correcto.setText("CORRECT!");
                    correcto.setVisibility(View.VISIBLE);
                    points += 31;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    score.setText(String.valueOf(points));
                    directions[last_event].setVisibility(View.INVISIBLE);
                    event(directions,buttons,words);
                }
                else{
                    wrong.show();
                    points -= 11;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    correcto.setText("WRONG!");
                    correcto.setVisibility(View.VISIBLE);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b2.getText().toString().equals(CorrectAnswer)){
                    correct.show();
                    correcto.setText("CORRECT!");
                    correcto.setVisibility(View.VISIBLE);
                    points += 31;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    score.setText(String.valueOf(points));
                    directions[last_event].setVisibility(View.INVISIBLE);
                    event(directions,buttons,words);
                }
                else{
                    wrong.show();
                    points -= 11;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    correcto.setText("WRONG!");
                    correcto.setVisibility(View.VISIBLE);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b3.getText().toString().equals(CorrectAnswer)){
                    correct.show();
                    correcto.setText("CORRECT!");
                    correcto.setVisibility(View.VISIBLE);
                    points += 31;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    score.setText(String.valueOf(points));
                    directions[last_event].setVisibility(View.INVISIBLE);
                    event(directions,buttons,words);
                }
                else{
                    wrong.show();
                    points -= 11;
                    userRef.child(CurrentName).child("score_directions").setValue(points);
                    correcto.setText("WRONG!");
                    correcto.setVisibility(View.VISIBLE);
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directions[last_event].setVisibility(View.INVISIBLE);
                event(directions,buttons,words);
                points = 0;
                score.setText(String.valueOf(points));
            }
        });
    }

    void event(ImageView[] arr,Button[] butts,String[] words){
        correcto.setVisibility(View.INVISIBLE);
        int []check_words = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        int []button_check = new int[]{1,1,1};
        while(last_event == event_number){
            event_number = randomizer(arr.length);
        }
        int button_number = randomizer(butts.length);
        arr[event_number].setVisibility(View.VISIBLE);
        butts[button_number].setText(words[event_number]);
        check_words[event_number] = 0;
        button_check[button_number] = 0;
        CorrectAnswer = words[event_number];
        last_event = event_number;
        for(int i = 0; i < 3; i++){
            if(button_check[i] == 1){
                while(check_words[event_number] == 0){
                    event_number = randomizer(arr.length);
                }
                butts[i].setText(words[event_number]);
                check_words[event_number] = 0;
            }
        }
    }

    int randomizer(int upper_bound){
        int max = upper_bound;
        Random rand = new Random();
        int int_random = rand.nextInt(max);
        return int_random;
    }
}