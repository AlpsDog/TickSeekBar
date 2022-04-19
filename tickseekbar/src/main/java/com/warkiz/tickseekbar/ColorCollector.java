package com.warkiz.tickseekbar;


import androidx.annotation.ColorInt;

/**
 * created by zhuangguangquan on 2018/6/6
 * <p>
 * for collecting each section track color
 */
public interface ColorCollector {
    boolean collectColor(@ColorInt int[] colorIntArr);
}