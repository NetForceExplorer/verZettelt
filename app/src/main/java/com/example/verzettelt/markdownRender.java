package com.example.verzettelt;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.yydcdut.markdown.MarkdownEditText;
import com.yydcdut.markdown.MarkdownProcessor;
import com.yydcdut.markdown.MarkdownTextView;
import com.yydcdut.markdown.syntax.edit.EditFactory;
import com.yydcdut.rxmarkdown.RxMDConfiguration;
import com.yydcdut.rxmarkdown.RxMDEditText;
import com.yydcdut.rxmarkdown.RxMDTextView;
import com.yydcdut.rxmarkdown.RxMarkdown;

public class markdownRender extends AppCompatActivity {

    private RxMDEditText mRxMDEditText;
    private RxMDTextView mRxMDTextView;
    private RxMDConfiguration mRxMDConfiguration;

    private MarkdownTextView mMarkdownTextView;
    private MarkdownEditText mMarkdownEditText;
    private MarkdownProcessor mMarkdownProcessor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_editor);

        //String content = (String) "test";

        //mRxMDEditText = (RxMDEditText) findViewById(R.id.zettelContextEditText);
        //mRxMDEditText.addTextChangedListener(this);
        //mRxMDEditText.setText(content);
        //mRxMDTextView = (RxMDTextView) findViewById(R.id.randomZettelText);

        //mMarkdownEditText = (MarkdownEditText) findViewById(R.id.edit_rx);
        //mMarkdownEditText.addTextChangedListener(this);
        //mMarkdownTextView = (MarkdownTextView) findViewById(R.id.txt_md_show);
        //mMarkdownEditText.setText(Const.MD_SAMPLE);

        //rxMarkdown(mRxMDEditText);
        //mRxMDEditText.setVisibility(View.VISIBLE);
        //mRxMDTextView.setVisibility(View.VISIBLE);

        }

    //public void rxMarkdown(RxMDEditText mRxMDEditText) {
    //    mRxMDConfiguration = new RxMDConfiguration.Builder(this)
    //            .setDefaultImageSize(400, 400)
    //            .setBlockQuotesLineColor(0xff33b5e5)
    //            .setHeader1RelativeSize(1.6f)
    //            .setHeader2RelativeSize(1.5f)
    //            .setHeader3RelativeSize(1.4f)
    //           .setHeader4RelativeSize(1.3f)
    //            .setHeader5RelativeSize(1.2f)
    //           .setHeader6RelativeSize(1.1f)
    //            .setHorizontalRulesColor(0xffaa66cc)
    //            .setCodeBgColor(0x33CCCCCC)
    //            .setTodoColor(0xff669900)
    //            .setTodoDoneColor(0xffff4444)
    //            .setUnOrderListColor(0xffffbb33)
    //            //.setRxMDImageLoader(new OKLoader(this))
    //            .showLinkUnderline(true)
    //            .setLinkFontColor(0xff00ddff)
    //            .build();
    //    //horizontalEditScrollView.setEditTextAndConfig(mRxMDEditText, mRxMDConfiguration);
    //    RxMarkdown.live(mRxMDEditText)
    //            .config(mRxMDConfiguration)
    //            .factory(EditFactory.create())
    //            .intoObservable()
//                .subscribeOn(Schedulers.computation())
//                .observeOn(AndroidSchedulers.mainThread())
    //            .subscribe();
    //}

}
