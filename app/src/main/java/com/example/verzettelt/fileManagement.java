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

    // our adapter class for feeding the data
    public class BasicListAdapter extends RecyclerView.Adapter<BasicListAdapter.SimpleViewHolder> {
        private String[] dataSource;

        // simple constructor
        public BasicListAdapter(String[] dataArgs) {
            dataSource = dataArgs;
        }

        // RecycleView.adapter needs a viewholder which holds multiple views in  a certain layout
        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View view = new TextView(parent.getContext());
            SimpleViewHolder viewHolder = new SimpleViewHolder(view);
            return viewHolder;
        }

        public class SimpleViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public SimpleViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.textView.setText(dataSource[position]);
        }

        // Item count based on list input; mainly used to count number of files
        @Override
        public int getItemCount() {
            return dataSource.length;
        }
    }


    // Go backk to main_activity
    public void onClickClose(View view) {
        finish();
    }



}
