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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.verzettelt.fileManagement.zettelPath;

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

    // Saving Zettel to internal Storagke
    public void saveZettel(View view)
    {
        //Convert edittext input into string
        String input = myZettel.getText().toString();
        //using file streams for writing and saving data
        FileOutputStream fos = null;
        // use try and catch errors if they are happening
        try {
            //open file
            fos = openFileOutput(filename, MODE_PRIVATE);
            //write file
            fos.write(input.getBytes());

            // Clear edittext view
            //myZettel.getText().clear();

            // Toast for success
            Toast.makeText(this, "Zettel " + filename +" is save!",
                    Toast.LENGTH_SHORT).show();
            // Catching different errors
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    // close file if finished
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //loading Zettel from storage
    public void loadZettel(View v) {
        //using FileInputStream instead of output stream
        FileInputStream fis = null;

        try {
            fis = openFileInput(zettelPath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            myZettel.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
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
