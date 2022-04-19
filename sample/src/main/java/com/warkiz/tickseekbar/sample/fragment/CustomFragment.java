package com.warkiz.tickseekbar.sample.fragment;

import android.graphics.Color;
import android.view.View;

import com.warkiz.tickseekbar.ColorCollector;
import com.warkiz.tickseekbar.TickSeekBar;
import com.warkiz.tickseekbar.sample.R;

/**
 * created by zhuangguangquan on 2018/6/6
 */

public class CustomFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.custom;
    }

    @Override
    protected void initView(View root) {
        TickSeekBar tickSeekBar = root.findViewById(R.id.custom_10);
        tickSeekBar.customTickMarksColor(new ColorCollector() {
            @Override
            public boolean collectColor(int[] colorIntArr) {
                for (int i = 0; i < 10; i++) {
                    if (i % 2 == 0) {
                        colorIntArr[i] = Color.parseColor("#DADADA");
                    } else {
                        colorIntArr[i] = Color.parseColor("#00DADADA");
                    }
                }
                return true;
            }
        });
    }
}
