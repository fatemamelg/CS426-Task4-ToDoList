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
    private itemLongClickListener mOnLongClickListener;

    public ToDoAdapter(Context ct, String t[], String d[], itemClickListener mOnClickListener, itemLongClickListener mOnLongClickListener) {
        ctx = ct;
        data1 = t;
        data2 = d;

        this.mOnClickListener = mOnClickListener;
        this.mOnLongClickListener = mOnLongClickListener;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx) ;
        View myView = myInflater.inflate(R.layout.my_row, parent, false);
        return new holder(myView, mOnClickListener, mOnLongClickListener);
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

    public class holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener  {
        TextView tv1, tv2;
        itemClickListener listItemClick;
        itemLongClickListener listItemLongClick;

        public holder (View itemView, itemClickListener listItemClick, itemLongClickListener listItemLongClick) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.textView);
            tv2 = (TextView) itemView.findViewById(R.id.textView2);
            this.listItemClick = listItemClick;
            this.listItemLongClick = listItemLongClick;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItemClick.onListItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public interface itemClickListener{
        void onListItemClick(int position);
    }

    public interface itemLongClickListener{
        void onListItemLongClick(int position);
    }
}
