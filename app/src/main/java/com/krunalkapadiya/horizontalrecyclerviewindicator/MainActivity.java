package com.krunalkapadiya.horizontalrecyclerviewindicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> mArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        addArrayList();


        HorizontalRVAdapter adapter = new HorizontalRVAdapter(MainActivity.this, mArrayList);
        recyclerView.setAdapter(adapter);


        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//                int position = recyclerView.getLayoutManager().getPosition(recyclerView);
                Log.d("RecyclerPostition", String.valueOf(i));
                Log.d("RecyclerPostition", String.valueOf(i2));
                Log.d("RecyclerPostition", String.valueOf(i3));

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("RecyclerPnewstate", String.valueOf(newState));
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy < 0) {

                    // Recycle view scrolling up...
                    Log.d("RecyclerPscroll", String.valueOf(dx));

                } else if (dy > 0) {
                    // Recycle view scrolling down...
                    Log.d("RecyclerPscroll", String.valueOf(dy));
                }
            }
        });
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
        mArrayList.add("Thor");
    }

    public void updateIndicator(int selectedPos) {


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.pager_indicator_container);
        linearLayout.removeAllViews();
        for (int i = 0; i < mArrayList.size() / 4; i++) {
            ImageView dot = new ImageView(this);
            if (i == selectedPos / 4) {
                dot.setImageResource(R.drawable.view_pager_indicator);
            } else {
                dot.setImageResource(R.drawable.view_pager_indicator_unselected);
            }
            dot.setPadding(0, 0, 30, 0);
            linearLayout.addView(dot);
        }
    }
}
