package com.example.hp0331.objview.activity;

import android.animation.TypeEvaluator;

/**
 * Created by Aaron.zhang
 * at  2017/2/28.
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int start = startValue.getRadius();
        int end  = endValue.getRadius();
        int curValue = (int)(start + fraction * (end - start));
        return new Point(curValue);

    }
}
