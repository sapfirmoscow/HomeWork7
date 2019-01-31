package ru.sberbank.homework7.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import ru.sberbank.homework7.R;

public class SecondFragment extends Fragment {

    private TextView mTextView;
    private MyRandomNumberTask mMyRandomNumberTask;

    public static SecondFragment newInstance() {

        Bundle args = new Bundle();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.textView_num);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMyRandomNumberTask.cancel(true);

    }

    public void setTextView(String randomNumber) {
        if (mTextView != null)
            mTextView.setText(randomNumber);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMyRandomNumberTask = new MyRandomNumberTask();
        mMyRandomNumberTask.execute();
    }


    private class MyRandomNumberTask extends AsyncTask<Void, Integer, Void> {

        private Random random = new Random();

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            setTextView(String.valueOf(values[0]));
        }

        @Override
        protected Void doInBackground(Void... voids) {
            while (!isCancelled()) {
                publishProgress(random.nextInt());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
