package ru.sberbank.homework7;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import ru.sberbank.homework7.fragments.FirstFragment;
import ru.sberbank.homework7.fragments.SecondFragment;
import ru.sberbank.homework7.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }

    private void initFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.first_frame_layout, FirstFragment.newInstance());
        fragmentTransaction.add(R.id.second_frame_layout, new SecondFragment());
        fragmentTransaction.add(R.id.third_frame_layout, new ThirdFragment());
        fragmentTransaction.commit();
    }
}
