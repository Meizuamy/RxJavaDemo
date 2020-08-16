package com.example.createoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SchedulerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        Scheduler.Worker worker = Schedulers.newThread().createWorker();
        worker.schedule(() -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}