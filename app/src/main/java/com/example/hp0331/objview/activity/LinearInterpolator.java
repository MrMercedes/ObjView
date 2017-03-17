package com.example.hp0331.objview.activity;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/**
 * Created by Aaron.zhang
 * at  2017/2/28.
 */

public class LinearInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }

    public LinearInterpolator() {
    }

}
