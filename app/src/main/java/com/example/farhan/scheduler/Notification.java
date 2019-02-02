package com.example.farhan.scheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class Notification extends AppCompatActivity {
    private LottieAnimationView lt_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        lt_view = (LottieAnimationView) findViewById(R.id.animation_view);
        lt_view.setAnimation("stopwatch.json");
        lt_view.loop(true);
        lt_view.playAnimation();


    }
}
