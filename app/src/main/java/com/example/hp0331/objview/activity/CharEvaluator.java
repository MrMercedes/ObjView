package com.example.hp0331.objview.activity;

import android.animation.TypeEvaluator;

/**
 * Created by Aaron.zhang
 * at  2017/2/28.
 */

public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;

    }
}
