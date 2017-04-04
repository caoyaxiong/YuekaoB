package com.bwie.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.R;
import com.bwie.test.adapter.ROneAdapter;
import com.bwie.test.adapter.RTwoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/4/1 14:34
 */

public class Fragment1 extends Fragment implements ROneAdapter.OnChildListener {

    private View view;
    private RecyclerView recyclerView1;
    private List<String> list;
    private ROneAdapter oneAdapter;
    private Fragment2 fragment2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.frag_one,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        //HttpHelp.getHttp(HttpUrl.url, InfoData.class, this);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recy1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        oneAdapter = new ROneAdapter(getActivity(),list);
        recyclerView1.setAdapter(oneAdapter);
        fragment2 = (Fragment2) getActivity().getSupportFragmentManager().findFragmentById(R.id.fram2);
        oneAdapter.setOnChildListener(this);
    }
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("目录" + i);
        }
    }

    @Override
    public void onChildListener( int position) {
        fragment2.setString(position);
    }
}
