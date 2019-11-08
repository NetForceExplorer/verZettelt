package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // open new Activities for the buttons
    public void onClickSwitchFileManagement(View view) {
        Intent intent = new Intent(this, fileManagement.class);
        startActivity(intent);
    }

    public void onClickSwitchEditor(View view) {
        Intent intent = new Intent(this, editor.class);
        startActivity(intent);
    }
}

