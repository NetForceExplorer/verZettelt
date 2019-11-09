package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_management);
        TextView myAwesomeTextView = (TextView) findViewById(R.id.idTextView);
        myAwesomeTextView.setText(id);

        //Using API Call in order to get a list of all files
        File file = getFilesDir();
        File f[] = file.listFiles();

        //Find id of Recycler view
        RecyclerView allZettelList = (RecyclerView) findViewById(R.id.allZettelRecycler);
        //Simple linear Layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        allZettelList.setLayoutManager(layoutManager);
        //In order to feed The data we need some adapter
        //allZettelList.setAdapter(new BasicListAdapter(this));

    }

    // our adapter class for feeding the data
    // RecycleView.adapter needs a viewholder which holds multiple views in  a certain layout


    public void onClickClose(View view) {
        finish();
    }



}
