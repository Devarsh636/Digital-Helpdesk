package com.example.digitalhelpdesk;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash_screen extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemClock.sleep(1500);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
