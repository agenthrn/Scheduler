package com.example.farhan.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;



import com.example.farhan.scheduler.Adapter.TaskAdapter;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity {


    Toolbar toolbar;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Task> data;
    private SlidingUpPanelLayout mLayout;
    private CalendarView calendar;
    private View task_onhold;
    private ImageView arrowUpMain,arrowDownMain;

    private TextView text1l;

    private Button btn, btnEditTask, btnDeleteTask;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Scheduler");

        btn = (Button)findViewById(R.id.btnCheck);
        btnEditTask = (Button) findViewById(R.id.btnEditTask);


        arrowUpMain = (ImageView) findViewById(R.id.arrow_up_main);
        arrowDownMain = (ImageView) findViewById(R.id.arrow_down);
        text1l = (TextView) findViewById(R.id.taskInfo);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.activity_main);

        task_onhold = (View) findViewById(R.id.task_onhold);



        calendar = (CalendarView) findViewById(R.id.calendar);
        task_onhold.setVisibility(View.GONE);
        calendar.setVisibility(View.GONE);


        addData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Notification.class);
                startActivity(i);
            }
        });

        btnEditTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EditTask.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rvTaskResult);
        adapter = new TaskAdapter(data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

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

        arrowUpMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task_onhold.setVisibility(View.GONE);
                calendar.setVisibility(View.VISIBLE);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });

        arrowDownMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(PanelState.COLLAPSED);

            }
        });


        mLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });


        text1l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.GONE);
                task_onhold.setVisibility(View.VISIBLE);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

            }
        });

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView,
                                         int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Calendar date, int position) {
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
        SearchView searchView = (SearchView) menu.findItem(R.id.searchForm).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("Task");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.add:
                Intent addIntent = new Intent(MainActivity.this, CreateTask.class);
                startActivity(addIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
