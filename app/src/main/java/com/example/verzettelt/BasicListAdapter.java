package com.example.verzettelt;

import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

// our adapter class for feeding the data
public class BasicListAdapter extends RecyclerView.Adapter<BasicListAdapter.SimpleViewHolder> {
    private String[] dataSource;
    private SparseBooleanArray selectedItems;

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

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.textView.setText(dataSource[position]);
        // add an onclick Listener to my view holder
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View itemView) {
                int test = 1+1;
                Toast.makeText(itemView.getContext(),"Loading Zettel: " + dataSource[position] , Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Item count based on list input; mainly used to count number of files
    @Override
    public int getItemCount() {
        return dataSource.length;
    }
}