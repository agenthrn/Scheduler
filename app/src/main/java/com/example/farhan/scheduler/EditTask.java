package com.example.farhan.scheduler;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TimePicker;

import com.example.farhan.scheduler.Adapter.GridAdapter;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.Calendar;

public class EditTask extends AppCompatActivity {
    private static final String TAG ="EditTask";
    Toolbar toolbar;
    private EditText mDisplayDate, mDisplayColor, mDisplayReminder;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private SlidingUpPanelLayout mLayout;
    private TimePicker timePicker;
    private Button buttonDeadline, buttonColorPicker, buttonReminder;
    private RelativeLayout deadlinePicker, colorPicker, reminderPicker;
    private GridView colorGridView;
    private NumberPicker npReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Task");

        colorGridView = (GridView) findViewById(R.id.gvColorPickerEdit) ;

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.edit_task);

        buttonDeadline = (Button) findViewById(R.id.buttonDeadlineEdit);
        buttonColorPicker = (Button) findViewById(R.id.buttonColorPickEdit);
        buttonReminder = (Button) findViewById(R.id.buttonReminderEdit);

        deadlinePicker = (RelativeLayout) findViewById(R.id.deadlinePickerEdit);
        colorPicker = (RelativeLayout) findViewById(R.id.colorPickerEdit);
        reminderPicker = (RelativeLayout) findViewById(R.id.reminderPickerEdit);
        reminderPicker.setVisibility(View.GONE);
        deadlinePicker.setVisibility(View.GONE);
        colorPicker.setVisibility(View.GONE);

        npReminder = (NumberPicker) findViewById(R.id.npReminderEdit);
        timePicker = (TimePicker) findViewById(R.id.timePickerEdit);
        npReminder = (NumberPicker) findViewById(R.id.npReminderEdit);

        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        npReminder.setMinValue(1);
        npReminder.setMaxValue(20);

        mDisplayDate = (EditText) findViewById(R.id.etDateEdit);
        mDisplayReminder = (EditText) findViewById(R.id.etStartToRemindEdit);
        mDisplayColor = (EditText) findViewById(R.id.etColorEdit);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deadlinePicker.setVisibility(View.VISIBLE);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });
        mDisplayColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                colorPicker.setVisibility(View.VISIBLE);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });
        mDisplayReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reminderPicker.setVisibility(View.VISIBLE);
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });

        mDataSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
            }
        };
        buttonDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                deadlinePicker.setVisibility(View.GONE);
            }
        });
        buttonColorPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                colorPicker.setVisibility(View.GONE);

            }
        });
        buttonReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                reminderPicker.setVisibility(View.GONE);
            }
        });
        colorGridView.setAdapter(new GridAdapter(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_create_task,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.cancel:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

