package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class fileManagement extends AppCompatActivity {
    identifier currentId = new identifier();
    String id = currentId.create();
    public static String zettelPath = "empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);
        final TextView myAwesomeTextView = (TextView) findViewById(R.id.idTextView);

        //Using API Call in order to get a list of all files as with string format
        //File file = getFilesDir();
        //File f[] = file.listFiles();
        String[] f = getFilesDir().list();

        myAwesomeTextView.setText(f[3]);

        //Find id of Recycler view
        RecyclerView allZettelList = (RecyclerView) findViewById(R.id.allZettelRecycler);
        //Simple linear Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        allZettelList.setLayoutManager(layoutManager);
        //In order to feed The data we need some adapter
        allZettelList.setAdapter(new BasicListAdapter(f));
    }


    // Go back to main_activity
    public void onClickClose(View view) {
        finish();
    }
}
