package com.example.hp0331.objview.activity;

import android.animation.TypeEvaluator;

/**
 * Created by Aaron.zhang
 * at  2017/2/28.
 */

public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        return (int)(200+startValue + fraction * (endValue - startValue));
    }
}
