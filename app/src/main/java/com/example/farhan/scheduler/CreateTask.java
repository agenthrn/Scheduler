package com.example.farhan.scheduler;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.TimePicker;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.Calendar;
import java.util.Date;

public class CreateTask extends AppCompatActivity {
    private static final String TAG ="CreateTask";
    Toolbar toolbar;
    private EditText mDisplayDate, mDisplayColor;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private SlidingUpPanelLayout mLayout;
    private TimePicker timePicker;
    private Button buttonDeadline, buttonColorPicker;
    private RelativeLayout deadlinePicker, colorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.create_task);

        buttonDeadline = (Button) findViewById(R.id.buttonDeadline);
        buttonColorPicker = (Button) findViewById(R.id.buttonColorPick);

        deadlinePicker = (RelativeLayout) findViewById(R.id.deadlinePicker);
        colorPicker = (RelativeLayout) findViewById(R.id.colorPicker);
        deadlinePicker.setVisibility(View.GONE);
        colorPicker.setVisibility(View.GONE);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        mDisplayDate = (EditText) findViewById(R.id.etDate);
        mDisplayColor = (EditText) findViewById(R.id.etColor);
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

    }
}

