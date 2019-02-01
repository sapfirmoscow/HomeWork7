package ru.sberbank.homework7;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;

import java.util.Random;


public class MyThread extends Thread {

    public final static int MESSAGE_UPDATE = 0;
    private final Handler mHandler;
    private final int ALPHA = 255;
    private Random mRandom;

    public MyThread(Handler handler) {
        mHandler = handler;
        mRandom = new Random();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(MESSAGE_UPDATE, getRandomColor());
            message.sendToTarget();
        }
    }

    private Integer getRandomColor() {
        return Color.argb(ALPHA, mRandom.nextInt(255), mRandom.nextInt(255), mRandom.nextInt(255));
    }
}
