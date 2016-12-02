package com.example.christian.listapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.christian.listapp.R;
import com.example.christian.listapp.adapter.OrgAdapter;
import com.example.christian.listapp.model.ListItem;
import com.example.christian.listapp.model.OrgData;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity implements OrgAdapter.ItemClickCallback {



    private RecyclerView recView;
    private OrgAdapter adapter;
    private ArrayList listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listData = (ArrayList) OrgData.getListData();

        recView = (RecyclerView)findViewById(R.id.my_rec_list);
        //Check out GridLayoutManager and StaggeredGridLayoutManager for more options
        recView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new OrgAdapter(listData, this);
        recView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }

    @Override
    public void onItemClick(int p) {
        ListItem item = (ListItem) listData.get(p);

        Intent i = new Intent(this, DetailActivity.class);

        startActivity(i);

    }
}


