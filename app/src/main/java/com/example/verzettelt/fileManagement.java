package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class fileManagement extends AppCompatActivity {
    identifier currentId = new identifier();
    String id = currentId.create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);
        TextView myAwesomeTextView = (TextView) findViewById(R.id.idTextView);
        myAwesomeTextView.setText(id);

        //Using API Call in order to get a list of all files
        File file = getFilesDir();
        File f[] = file.listFiles();
        
    }

    public void onClickClose(View view) {
        finish();
    }



}
