package com.example.createoperation;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreateActivity extends AppCompatActivity {

    private static final String TAG = CreateActivity.class.getSimpleName();

    private Observable myObservable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

//        // 普通的 just
//        Observable.just("hello")
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG, "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Log.d(TAG, "onNext : " + s);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d(TAG, "onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete");
//                    }
//                });
//
//        // 普通的 create
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
//                emitter.onNext("Hello");
//                emitter.onComplete();
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG, "onSubscribe");
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Log.d(TAG, "onNext : " + s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d(TAG, "onError");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete");
//            }
//        });
//
//        // 普通的 defer
//        Observable<Integer> source = Observable
//                .defer(() -> getSource());



//        source
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getObserver());
//
//        source.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getObserver());


//        Observable.error(new Throwable("Hello Error!"))
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG,"onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Object o) {
//                        Log.d(TAG,"onNext");
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG,"onComplete");
//                    }
//                });

//        Observable.never()
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG,"onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Object o) {
//                        Log.d(TAG,"onNext");
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG,"onComplete");
//                    }
//                });

//        Observable.empty()
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG,"onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Object o) {
//                        Log.d(TAG,"onNext");
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG,"onComplete");
//                    }
//                });

//        Integer[] items = { 0,1,2,3,4,5 };
//
//        myObservable = Observable.fromArray(items);
//
//        myObservable.observeOn(Schedulers.computation())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                Log.d(TAG,"onSubscribe");
//            }
//
//            @Override
//            public void onNext(Integer num) {
//                Log.d(TAG,"Current number is : " + num);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.e(TAG,"发生错误：" + e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG,"onComplete");
//            }
//        });

        // 直接使用interval会造成内存泄露，导致Activity退出之后，interval仍然在运行，因为interval默认是运行
        // 在computation线程上。

//        Observable.interval(1000l, TimeUnit.MILLISECONDS)
//                .subscribe(aLong -> {
//                    Log.d(TAG,"this time is :" + aLong);
//                });

//        Observable.interval(1000l,TimeUnit.MILLISECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG,"onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Long aLong) {
//                        Log.d(TAG,"Next is :" + aLong);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.e(TAG,"onError");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG,"onComplete");
//                    }
//                });

        Observable myObservable1 = Observable.interval(1000l,TimeUnit.MILLISECONDS).takeUntil(aLong -> aLong == 10);
        Observable myObservable = Observable.interval(1000l,TimeUnit.MILLISECONDS,AndroidSchedulers.mainThread()).takeUntil(aLong -> aLong == 10);
        myObservable.doOnSubscribe(disposable -> Log.d(TAG,"doOnSubscribe"));
        myObservable.subscribe(aLong->{
            Log.d(TAG,"this time is " + aLong);
        });
    }

    private ObservableSource<? extends Integer> getSource() {
        return Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onComplete();
        });
    }

    private Observer<? super Integer> getObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d(TAG, "接收到 ：" + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
    }
}