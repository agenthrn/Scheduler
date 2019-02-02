package com.example.farhan.scheduler;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;

import android.support.design.widget.FloatingActionButton;
import com.mancj.slideup.SlideUp;
import com.mancj.slideup.SlideUpBuilder;

import com.example.farhan.scheduler.Adapter.TaskAdapter;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Task> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scheduler");


        addData();

        recyclerView = (RecyclerView) findViewById(R.id.rvTaskResult);
        adapter = new TaskAdapter(data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("EEE")
                .formatMiddleText("dd")
                .formatBottomText("MMM")
                .end()
                .defaultSelectedDate(Calendar.getInstance())
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
                return true;
            }
        });


    }

    public void addData(){
        data = new ArrayList<>();
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
        data.add(new Task("Make poster design","04.00 pm","Mon, 7 Jan 2019"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.search:
                Intent addIntent = new Intent(MainActivity.this, SearchTask.class);
                startActivity(addIntent);
                break;
            case R.id.add:
                addIntent = new Intent(MainActivity.this, CreateTask.class);
                startActivity(addIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
