package com.example.a2004projeson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.Random;

public class similarPicturesActivity extends AppCompatActivity {
    ImageView true_picture,answer1,answer2,answer3,answer4;
    Button reset;

    String CurrentName;

    protected int userScore = 0;
    Drawable square,square1,square2,square3,star,star1,star2,star3,heart,heart1,heart2,heart3,altigen,altigen1,altigen2,altigen3,
            triangle,triangle1,triangle2,triangle3;
    int event_case;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        Toast.makeText(this,currentname,Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_similar_pictures);
        true_picture = findViewById(R.id.true_picture);
        reset = findViewById(R.id.button19);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        square = ContextCompat.getDrawable(this,R.drawable.square3);
        square1 = ContextCompat.getDrawable(this,R.drawable.square1);
        square2 = ContextCompat.getDrawable(this,R.drawable.square);
        square3 = ContextCompat.getDrawable(this,R.drawable.square4);
        star = ContextCompat.getDrawable(this,R.drawable.star);
        star1 = ContextCompat.getDrawable(this,R.drawable.star2);
        star2 = ContextCompat.getDrawable(this,R.drawable.star3);
        star3 = ContextCompat.getDrawable(this,R.drawable.star4);
        heart = ContextCompat.getDrawable(this,R.drawable.heart);
        heart1 = ContextCompat.getDrawable(this,R.drawable.heart2);
        heart2 = ContextCompat.getDrawable(this,R.drawable.heart3);
        heart3 = ContextCompat.getDrawable(this,R.drawable.heart1);
        altigen = ContextCompat.getDrawable(this,R.drawable.altigen);
        altigen1 = ContextCompat.getDrawable(this,R.drawable.altigen1);
        altigen2 = ContextCompat.getDrawable(this,R.drawable.altigen2);
        altigen3 = ContextCompat.getDrawable(this,R.drawable.altigen3);
        triangle = ContextCompat.getDrawable(this,R.drawable.triangle);
        triangle1 = ContextCompat.getDrawable(this,R.drawable.triangle1);
        triangle2 = ContextCompat.getDrawable(this,R.drawable.triangle2);
        triangle3 = ContextCompat.getDrawable(this,R.drawable.triangle3);
        Drawable []triangles = new Drawable[]{triangle,triangle1,triangle2,triangle3};
        Drawable []altigenler = new Drawable[]{altigen,altigen1,altigen2,altigen3};
        Drawable []hearts = new Drawable[]{heart,heart1,heart2,heart3};
        Drawable []stars = new Drawable[]{star,star1,star2,star3};
        Drawable []squares = new Drawable[]{square,square1,square2,square3};
        ImageView []pictures = new ImageView[]{true_picture,answer1,answer2,answer3,answer4};
        event(squares,pictures);
        event_case++;

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                event(altigenler,pictures);
            }
        });

        for (ImageView picture : pictures) {
            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(event_case) {
                        case 0:
                            handleAnswerClick((ImageView) v, pictures,triangles);
                            event_case++;
                            break;
                        case 1:
                            handleAnswerClick((ImageView) v,pictures,altigenler);
                            event_case++;
                            break;
                        case 2:
                            handleAnswerClick((ImageView) v,pictures,hearts);
                            event_case++;
                            break;
                        case 3:
                            handleAnswerClick((ImageView) v,pictures,stars);
                            event_case++;
                            break;
                        case 4:
                            handleAnswerClick((ImageView) v,pictures,squares);
                            event_case = 0;
                            break;
                        default:
                            event_case = 0;
                    }
                }
            });
        }

    }

    void handleAnswerClick(ImageView clickedImage, ImageView[] img,Drawable[] answers) {
        // Compare the clicked image with the true picture
        if (clickedImage.getDrawable() == true_picture.getDrawable()) {
            userScore += 31;
            userRef.child(CurrentName).child("score_pictures").setValue(userScore);
            // Correct answer
            // Handle the correct answer logic here
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            event(answers,img);
        } else {
            // Incorrect answer
            // Handle the incorrect answer logic here
            userScore -= 11;
            userRef.child(CurrentName).child("score_pictures").setValue(userScore);
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
    void event(Drawable []arr, ImageView []pictures){
        randomizeArray(arr);
        pictures[0].setImageDrawable(arr[0]);
        int arr_index = 1;
        randomizeArray(arr);
        for(int i = 0; i < arr.length;i++){
            pictures[arr_index].setImageDrawable(arr[i]);
            arr_index++;
        }
    }
    static void randomizeArray(Drawable[] array) {
        Random rand = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            // Generate a random index between 0 and i (inclusive)
            int j = rand.nextInt(i + 1);

            // Swap array[i] with array[j]
            Drawable temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}