package ru.sberbank.homework7.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.sberbank.homework7.MyAdapter;
import ru.sberbank.homework7.MyThread;
import ru.sberbank.homework7.R;


public class ThirdFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyThread mMyThread;

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MyThread.MESSAGE_UPDATE:
                    mMyAdapter.setData((Integer) msg.obj);
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    };

    public static ThirdFragment newInstance() {
        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
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
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
    }

    private void initRecyclerView(View v) {
        mRecyclerView = v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mMyAdapter = new MyAdapter();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMyThread = new MyThread(mHandler);
        mMyThread.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMyThread.interrupt();
    }
}
