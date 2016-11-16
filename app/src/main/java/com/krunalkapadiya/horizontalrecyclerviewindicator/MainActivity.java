package com.krunalkapadiya.horizontalrecyclerviewindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        addArrayList();
        HorizontalRVAdapter adapter = new HorizontalRVAdapter(MainActivity.this,mArrayList);
        recyclerView.setAdapter(adapter);

    }

    private void addArrayList() {
        mArrayList = new ArrayList<>();
        mArrayList.add("Spider Man");
        mArrayList.add("Iron Man");
        mArrayList.add("Captain America");
        mArrayList.add("Deadpool");
        mArrayList.add("Daredevil");
        mArrayList.add("Dr Strange");
        mArrayList.add("Hulk");
        mArrayList.add("Thor");
    }
}
