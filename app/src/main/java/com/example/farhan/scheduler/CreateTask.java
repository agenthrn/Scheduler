package com.example.farhan.scheduler;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.TimePicker;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.Calendar;
import java.util.Date;

public class CreateTask extends AppCompatActivity {
    private static final String TAG ="CreateTask";
    Toolbar toolbar;
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private SlidingUpPanelLayout mLayout;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.create_task);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

        mDisplayDate = (EditText) findViewById(R.id.etDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    }
}

