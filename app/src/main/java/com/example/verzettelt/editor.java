package com.example.verzettelt;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yydcdut.markdown.MarkdownConfiguration;
import com.yydcdut.markdown.MarkdownEditText;
import com.yydcdut.markdown.MarkdownProcessor;
import com.yydcdut.markdown.MarkdownTextView;
import com.yydcdut.markdown.syntax.edit.EditFactory;
import com.yydcdut.markdown.theme.ThemeDefault;
import com.yydcdut.rxmarkdown.RxMDConfiguration;
import com.yydcdut.rxmarkdown.RxMDEditText;
import com.yydcdut.rxmarkdown.RxMDTextView;
import com.yydcdut.rxmarkdown.RxMarkdown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class editor extends AppCompatActivity {

    //private RxMDEditText mRxMDEditText;
    //private RxMDTextView mRxMDTextView;
    //private RxMDConfiguration mRxMDConfiguration;

    //private MarkdownTextView mMarkdownTextView;
    //private MarkdownEditText mMarkdownEditText;
    //private MarkdownProcessor mMarkdownProcessor;

    EditText myZettel;
    identifier currentId = new identifier();
    String filename = currentId.create() + ".md";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        myZettel = findViewById(R.id.zettelContextEditText);
    }

    // Saving Zettel to internal Storage
    public void saveZettel(View view)
    {
        //Get
        String input = myZettel.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(filename, MODE_PRIVATE);
            fos.write(input.getBytes());

            myZettel.getText().clear();
            Toast.makeText(this, "Zettel is " + filename +" is save!",
                    Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void onClickClose(View view) {
        finish();
    }

}
