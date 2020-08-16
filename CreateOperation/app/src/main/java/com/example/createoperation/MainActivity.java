package com.example.createoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.reactivestreams.Subscriber;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Flowable.range(1, 10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(System.out::println);
    }

    public void create(View view) {
        Intent intent = new Intent(this,CreateActivity.class);
        startActivity(intent);
    }

    public void filter(View view) {
        Intent intent = new Intent(this,FilterAcvivity.class);
        startActivity(intent);
    }

    public void transform(View view) {
        Intent intent = new Intent(this,TransformActivity.class);
        startActivity(intent);
    }

    public void backpressure(View view) {
        Intent intent = new Intent(this,BackpressureActivity.class);
        startActivity(intent);
    }

    public void scheduler(View view) {
        Intent intent = new Intent(this,SchedulerActivity.class);
        startActivity(intent);
    }
}