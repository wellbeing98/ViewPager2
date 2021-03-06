package com.haruple97.viewpager2_slider_opensource;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_1 extends Fragment {

    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private int count = -1;
    LinearLayoutManager mLinearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_1p, container, false);
        RecyclerView mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview_main_list);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);



        Button buttonInsert = (Button) getActivity().findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;

                Dictionary data = new Dictionary(count+"","Apple" + count, "사과" + count);

                mArrayList.add(0, data); //RecyclerView의 첫 줄에 i삽입
//                mArrayList.add(data); // RecyclerView의 마지막 줄에 삽입

                mAdapter.notifyDataSetChanged();             }
        });

        return rootView;
    }


}
