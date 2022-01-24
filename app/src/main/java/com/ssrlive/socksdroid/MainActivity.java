package com.ssrlive.socksdroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new ProfileFragment()).commit();
    }
}
