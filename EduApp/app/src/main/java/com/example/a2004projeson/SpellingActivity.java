package com.example.a2004projeson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Random;

public class SpellingActivity extends AppCompatActivity {
    private ImageView book, car, coffee, pencil, hospital,ahmetkayo,t0,t1,t2,t3,t4,t5,t6,t7,portal1,portal2;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users");
    String CurrentName;
    protected int index = 0;

    protected int userScore = 0;
    boolean isButtonEnabled = true;
    private int ahmet_index = 0;
    protected int event_number =0;
    protected int word_index = event_number;
    public String CorrectWord = "";
    protected Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelling);
        Intent intent = getIntent();
        String currentname = intent.getStringExtra("username");
        CurrentName = currentname;
        Toast.makeText(this,currentname,Toast.LENGTH_SHORT).show();
        book = findViewById(R.id.book);
        car = findViewById(R.id.car);
        coffee = findViewById(R.id.coffee);
        pencil = findViewById(R.id.pencil);
        hospital = findViewById(R.id.hospital);
        TextView spelledWord = findViewById(R.id.Spelled_word);
        TextView spelledWord2 = findViewById(R.id.spelled_word1);
        TextView spelledWord3 = findViewById(R.id.spelled_word3);
        TextView spelledWord4 = findViewById(R.id.spelled_word4);
        TextView spelledWord5 = findViewById(R.id.spelled_word5);
        TextView spelledWord6 = findViewById(R.id.spelled_word6);
        TextView spelledWord7 = findViewById(R.id.spelled_word7);
        TextView spelledWord8 = findViewById(R.id.spelled_word8);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11= findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        test = findViewById(R.id.button15);
        t0 = findViewById(R.id.tramp1);
        t1 = findViewById(R.id.tramp2);
        t2 = findViewById(R.id.tramp3);
        t3 = findViewById(R.id.tramp4);
        t4 = findViewById(R.id.tramp5);
        t5 = findViewById(R.id.tramp6);
        t6 = findViewById(R.id.tramp7);
        t7 = findViewById(R.id.tramp8);
        portal1 = findViewById(R.id.imageView);
        portal2 = findViewById(R.id.imageView2);
        ahmetkayo = findViewById(R.id.ahmetcim);
        Button next = findViewById(R.id.next);
        final float ahmetx = ahmetkayo.getX();
        final float ahmety = ahmetkayo.getY();
        TextView[] showed_word = new TextView[]{spelledWord,spelledWord2,spelledWord3,spelledWord4,spelledWord5,spelledWord6,spelledWord7,spelledWord8};
        ImageView[] pictures = new ImageView[]{book,car,coffee,pencil,hospital};
        Button[] letters = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14};
        ImageView[] tramps = new ImageView[]{t0,t1,t2,t3,t4,t5,t6,t7};
        String[] words = new String[]{"book","car","coffee","pencil","hospital"};
        clearLetters(letters);
        clearPictures(pictures);
        clearTramps(tramps);
        clearCorrectWord(showed_word);
        test.setVisibility(View.INVISIBLE);
        event(words[event_number], letters, pictures[event_number]);
        Handler handler = new Handler();
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isButtonEnabled) {
                    test.setEnabled(false);
                    isButtonEnabled = false;
                    ahmetkayo.setVisibility(View.VISIBLE);
                    ahmetkayo.animate().translationXBy(67).translationYBy(-90).setDuration(600);
                    ahmet_index++;
                    test.setText(String.valueOf(ahmet_index));
                    Handler handler = new Handler();
                    Handler handler1 = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ahmetkayo.animate().translationXBy(67).translationYBy(+90).setDuration(600).setInterpolator(new AccelerateDecelerateInterpolator());
                            if (ahmet_index == words[word_index].length()) {
                                ahmetkayo.animate().translationX(portal2.getX()).translationY(portal2.getY() - 650).setDuration(600).setInterpolator(new AccelerateDecelerateInterpolator());
                            }
                        }
                    }, 600);

                    if (ahmet_index == words[word_index].length()) {
                        test.setVisibility(View.INVISIBLE);
                        next.setVisibility(View.VISIBLE);
                        Handler handler2 = new Handler();
                        handler2.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ahmetkayo.setVisibility(View.INVISIBLE);
                                ahmetkayo.animate().translationX(ahmetx).translationY(ahmety).setDuration(400);
                            }
                        }, 1500);
                    }
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            test.setEnabled(true);
                            isButtonEnabled = true;
                        }
                    }, 1250);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ahmet_index = 0;
                if(event_number == 4){
                    event_number = 0;
                }
                else
                    event_number++;
                word_index = event_number;
                clearLetters(letters);
                clearPictures(pictures);
                clearCorrectWord(showed_word);
                clearTramps(tramps);
                event(words[event_number], letters, pictures[event_number]);
                CorrectWord = "";
                index = 0;
                next.setVisibility(View.INVISIBLE);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b1.getText() + "";
                if (temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b1.getVisibility() == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    index++;
                    b1.setVisibility(View.INVISIBLE);
                    if (index == words[word_index].length()) {
                        userScore += 20;
                        Toast.makeText(SpellingActivity.this, "Lets Try jumping", Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b2.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b2.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b2.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b3.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b3.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b3.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b4.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b4.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b4.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b5.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b5.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b5.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b6.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b6.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b6.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b7.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b7.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b7.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b8.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b8.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b8.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b9.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b9.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b9.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b10.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b10.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b10.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b11.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b11.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b11.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b12.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b12.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b12.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b13.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b13.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b13.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });

        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = b14.getText() + "";
                if(temp.toLowerCase().equals("" + words[word_index].charAt(index)) && b14.getVisibility()  == View.VISIBLE) {
                    showed_word[index].setText(String.valueOf(temp));
                    tramps[index].setVisibility(View.VISIBLE);
                    index++;
                    userScore += 20;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                    b14.setVisibility(View.INVISIBLE);
                    if(index == words[word_index].length()){
                        Toast.makeText(SpellingActivity.this,"Correct bro",Toast.LENGTH_SHORT).show();
                        test.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    userScore -= 10;
                    userRef.child(CurrentName).child("score_spelling").setValue(userScore);
                }
            }
        });


    }
    void event(String word,Button arr[],ImageView pic){
        pic.setVisibility(View.VISIBLE);
        for(int i = 0; i < word.length(); i++){
            int k = 0;
            int temp_rand_numb = randomizer(14);
            if(arr[temp_rand_numb].getVisibility() == View.INVISIBLE) {
                arr[temp_rand_numb].setText("" + word.charAt(i));
                arr[temp_rand_numb].setVisibility(View.VISIBLE);
            }
            else {
                while(arr[temp_rand_numb + k].getVisibility() == View.VISIBLE){
                    k++;
                    if(temp_rand_numb + k == 14){
                        k = 0;
                        temp_rand_numb = 0;
                    }
                }
                arr[temp_rand_numb + k].setText(""+word.charAt(i));
                arr[temp_rand_numb + k].setVisibility(View.VISIBLE);
            }
        }
        index = 0;
    }

    void clearTramps(ImageView[] arr){
        for(int i = 0; i < arr.length;i++){
            arr[i].setVisibility(View.INVISIBLE);
        }
    }

    void clearCorrectWord(TextView[] arr){
        for(int i = 0; i < arr.length;i++){
            arr[i].setText("");
        }
    }
    void clearLetters(Button[] arr){
        for(int i = 0; i < arr.length;i++){
            arr[i].setVisibility(View.INVISIBLE);
        }
    }

    void clearPictures(ImageView[] arr){
        for(int i = 0; i < arr.length;i++){
            arr[i].setVisibility(View.INVISIBLE);
        }
    }

    int randomizer(int upper_bound){
        int max = upper_bound;
        Random rand = new Random();
        int int_random = rand.nextInt(max);
        return int_random;
    }
}