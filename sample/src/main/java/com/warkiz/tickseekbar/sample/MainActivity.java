package com.warkiz.tickseekbar.sample;

import android.os.Bundle;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.warkiz.tickseekbar.sample.fragment.ContinuousFragment;
import com.warkiz.tickseekbar.sample.fragment.CustomFragment;
import com.warkiz.tickseekbar.sample.fragment.DiscreteFragment;
import com.warkiz.tickseekbar.sample.fragment.JavaBuildFragment;
import com.warkiz.tickseekbar.sample.fragment.donation.DonationFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhuangguangquan on 2018/6/6
 */

public class MainActivity extends AppCompatActivity {

    private static String[] sType = new String[]{"continuous", "discrete", "custom", "java", "donation"};
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initViews();
    }

    private void initFragment() {
        mFragmentList.add(new ContinuousFragment());
        mFragmentList.add(new DiscreteFragment());
        mFragmentList.add(new CustomFragment());
        mFragmentList.add(new JavaBuildFragment());
        mFragmentList.add(new DonationFragment());
    }

    private void initViews() {
        ViewPager viewPager =  findViewById(R.id.viewPager);
        TabLayout tabLayout =  findViewById(R.id.tabLayout);

        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        for (String s : sType) {
            TextView textView = new TextView(this);
            textView.setText(s);
            tabLayout.newTab().setCustomView(textView);
        }
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return sType.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return sType[position];
        }
    }

}
