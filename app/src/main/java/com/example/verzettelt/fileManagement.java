package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        TextView myAwesomeTextView = (TextView)findViewById(R.id.idTextView);
        myAwesomeTextView.setText(id);
    }
    public void onClickClose(View view) {
        finish();
    }

}
