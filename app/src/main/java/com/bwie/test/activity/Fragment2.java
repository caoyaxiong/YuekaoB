package com.bwie.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.test.R;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/4/1 14:34
 */

public class Fragment2 extends Fragment {

    private View view;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.image,null);
        imageView = (ImageView) view.findViewById(R.id.image);
        return view;
    }
    public void setString(int position){
        int i=position%2;
        if(i==0){
            Glide.with(getContext())
                    .load(R.mipmap.ic_launcher)
                    .into(imageView);
        }
        if(i==1){
            Glide.with(getContext())
                    .load(R.mipmap.vp2)
                    .into(imageView); 
        }
    }
}
