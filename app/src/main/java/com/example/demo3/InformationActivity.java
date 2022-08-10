package com.example.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class InformationActivity extends AppCompatActivity {


    private TabLayout mTableLayout;
    private ViewPager2 mViewPager2;
    private TextView TextFullName;
    private TextView TextBirthDay;
    private TextView TextAbout;
    private ViewPagerAdapter mviewPagerAdapter;
    public static String KeyUserFullName="UserFullName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_actvity);

        getSupportActionBar().setTitle(" Information ");


        TextFullName = findViewById(R.id.FullName);
        TextBirthDay = findViewById(R.id.Birthday);
        TextAbout = findViewById(R.id.About);
        Intent mIntent = getIntent();
        String UserFullName = getIntent().getStringExtra(KeyUserFullName);
        String UserBirthday = getIntent().getStringExtra("UserDemoone");
        String UserAbout = getIntent().getStringExtra("UserDemoone1");
        TextFullName.setText(UserFullName);
        TextBirthDay.setText(UserBirthday);
        TextAbout.setText(UserAbout);


        mTableLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.view_pager2);

        mviewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(mviewPagerAdapter);

        new TabLayoutMediator(mTableLayout , mViewPager2,(tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Job");
                    break;
                case 1:
                    tab.setText("Address");
                    break;
            }
        }).attach();

    }
}