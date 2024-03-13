package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReadingActivity extends AppCompatActivity {
    ImageView ball,box1,box2,box3,box4,box5,box6,box7,box8;
    TextView Debugger,score_board;
    Button animate;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;

    Animation animation;
    int index= 0;
    int score = 0;
    int bee_index = 0;
    boolean play = true;

    //ScaleAnimation scale = new ScaleAnimation((float)0.5,(float)1,(float)0.5,(float)1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        Toast.makeText(this,currentname,Toast.LENGTH_SHORT).show();
        ball = findViewById(R.id.Ball);
        animate = (Button) findViewById(R.id.startAnimation);
//        animation = AnimationUtils.loadAnimation(this,R.anim.move_next_line);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);
        box5 = findViewById(R.id.box5);
        box6 = findViewById(R.id.box6);
        box7 = findViewById(R.id.box7);
        box8 = findViewById(R.id.box8);
        Debugger = findViewById(R.id.Debug);
        score_board = findViewById(R.id.Reading_Score);
        //scale.setFillAfter(true);
        //scale.setDuration(800);

        ImageView []boxes = new ImageView[]{box1,box2,box3,box4,box5,box6,box8,box7};
        clearBoxes(boxes);

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 0){
                    ball.animate().translationYBy(500);
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).scaleX(1).scaleY(1).setDuration(1500).setInterpolator(new AccelerateDecelerateInterpolator());
                    score_board.setText(String.valueOf(score));
                }
                else{
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    Debugger.setText("Ooops try again ):");
                    score_board.setText(String.valueOf(score));
                }
            }
        });
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 1){
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).scaleX(1).scaleY(1).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                    score_board.setText(String.valueOf(score));
                }
                else{
                    Debugger.setText("Ooops try again ):");
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                }
            }
        });
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 2){
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    Debugger.setText("Ooops try again ):");
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                }
            }
        });
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 3){
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    Debugger.setText("Ooops try again ):");
                    score -=10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                }
            }
        });
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 4){
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    score -=10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    Debugger.setText("Ooops try again ):");
                }
            }
        });
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 5){
                    Debugger.setText("Congrats you found the bee!!!");
                    index++;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    bee_index++;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    Debugger.setText("Ooops try again ):");
                }
            }
        });
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 7){
                    Debugger.setText("Congrats you found the bee!!!");
                    index = 0;
                    score += 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    bee_index = 0;
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    Debugger.setText("Ooops try again ):");
                }
            }
        });
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bee_index == 6){
                    Debugger.setText(R.string.Congrats);
                    index++;
                    bee_index++;
                    score+= 50;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
                }
                else{
                    score -= 10;
                    userRef.child(CurrentName).child("score_reading").setValue(score);
                    score_board.setText(String.valueOf(score));
                    Debugger.setText("Ooops try again ):");
                }
            }
        });

        //ball.startAnimation(move);
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                bee_index = 0;
                score =0;
                ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() + 50).setDuration(2500).setInterpolator(new AccelerateDecelerateInterpolator());
            }
        });

        /*
        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index > 7){
                    index = 0;
                    boxes[index].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Debugger.setText("You Found The bee congrats!!!");
                            ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() - 50).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
                            clearBoxes(boxes);
                        }
                    });
                    index++;
                }
                else {
                    boxes[index].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Debugger.setText("You Found The bee congrats!!!");
                            ball.setVisibility(View.VISIBLE);
                            ball.animate().translationX(boxes[index].getX()).translationY(boxes[index].getY() - 50).setDuration(1000).setInterpolator(new AccelerateDecelerateInterpolator());
                        }
                    });
                    index++;

                }
                //ball.startAnimation(move);
            }
        });


         */

    }


    void clearBoxes(ImageView[] arr){
        for(int i = 0; i < arr.length;i++) {
            arr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Debugger.setText("ooops Try again ):");
                }
            });
        }
    }
}