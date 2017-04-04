package com.bwie.test.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;
import com.bwie.test.activity.MainActivity;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/4/1 08:10
 */

public class RTwoAdapter extends RecyclerView.Adapter<RTwoAdapter.MyViewHolder> implements View.OnClickListener {
    private final Context context;
    private OnChildListener listener;
    private RecyclerView recyclerView;

   
    public RTwoAdapter( Context context) {
        this.context=context;
    }


    public void setOnChildListener(OnChildListener onChildListener) {
        this.listener = onChildListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.image,parent,false);
        view.setOnClickListener(this);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView=recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView=recyclerView;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       
    }

  

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onClick(View v) {
        if(recyclerView!=null&&listener!=null){
            int position=recyclerView.getChildAdapterPosition(v);
            listener.onChildListener(recyclerView,v,position);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView im;

        public MyViewHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.image);
        }
    }
    public interface OnChildListener {

        void onChildListener(RecyclerView recyclerView, View v, int position);
    }
}
