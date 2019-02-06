package com.example.farhan.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.farhan.scheduler.Adapter.TaskAdapter;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {
    private LottieAnimationView lt_view;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Task> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        lt_view = (LottieAnimationView) findViewById(R.id.animation_view);
        lt_view.setAnimation("stopwatch.json");
        lt_view.loop(true);
        lt_view.playAnimation();

        addData();

        recyclerView = (RecyclerView) findViewById(R.id.rvNotifResult);
        adapter = new TaskAdapter(data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Notification.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

            }

    public void addData(){
        data = new ArrayList<>();
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
    }
}
