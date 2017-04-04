package com.bwie.test.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.activity.MainActivity;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/4/1 08:10
 */

public class ROneAdapter extends RecyclerView.Adapter<ROneAdapter.MyViewHolder>  {
    private final Context context;
    private final List<String> list;
    private OnChildListener listener;
    private int num=0;

    public ROneAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    public void setOnChildListener(OnChildListener onChildListener) {
        this.listener = onChildListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recy_one,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

   

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if(position==num){
            holder.textView.setBackgroundColor(Color.RED);
           
        }else{
            
            holder.textView.setBackgroundColor(Color.WHITE);
        }
        holder.textView.setText(list.get(position).toString());
        
    }

  

    @Override
    public int getItemCount() {
        return list.size();
    }

   

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    num=getPosition();
                    listener.onChildListener(num);
                    notifyDataSetChanged();
                }
            });
        }
    }
    public interface OnChildListener {

        void onChildListener(int i);
    }
}
