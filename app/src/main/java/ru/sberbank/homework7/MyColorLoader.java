package ru.sberbank.homework7;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.Random;

public class MyColorLoader extends AsyncTaskLoader<Integer> {

    private final int ALPHA = 255;
    private Random mRandom;

    public MyColorLoader(@NonNull Context context) {
        super(context);
        mRandom = new Random();
    }

    @Nullable
    @Override
    public Integer loadInBackground() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getRandomColor();

    }

    private Integer getRandomColor() {
        return Color.argb(ALPHA, mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }
}
