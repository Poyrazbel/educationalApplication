package com.example.a2004projeson;

public class Users {
    String userName;
    int score_reading;
    public Users(){
    }

    public Users(String userName,int score_reading){
        this.userName = userName;
        this.score_reading = score_reading;
    }

    public String getEmail() {
        return userName;
    }

    public int getScore_reading() {
        return score_reading;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore_reading(int score_reading) {
        this.score_reading = score_reading;
    }
}