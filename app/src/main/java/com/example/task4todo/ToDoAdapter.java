package com.example.task4todo;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.holder>  {

    String data1[], data2[];
    Context ctx;

    private itemClickListener mOnClickListener;

    public ToDoAdapter(Context ct, String t[], String d[], itemClickListener mOnClickListener) {
        ctx = ct;
        data1 = t;
        data2 = d;

        this.mOnClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx) ;
        View myView = myInflater.inflate(R.layout.my_row, parent, false);
        return new holder(myView, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.tv1.setText(data1[position]);
        holder.tv2.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv1, tv2;
        itemClickListener listItemClick;

        public holder (View itemView, itemClickListener listItemClick) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.textView);
            tv2 = (TextView) itemView.findViewById(R.id.textView2);
            this.listItemClick = listItemClick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItemClick.onListItemClick(getAdapterPosition());
        }
    }

    public interface itemClickListener{

        void onListItemClick(int position);
    }
}
