package com.example.hp0331.objview.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Aaron.zhang
 * at  2017/2/27.
 */

public class MoveView extends ImageView {


    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int lastx = 0;
    int lasty = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastx = x;
                lasty = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetx = x - lastx;
                int offsety = y - lasty;
//                layout(getLeft()+offsetx,getTop()+offsety,getRight()+offsetx,getBottom()+offsety);
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                lp.leftMargin = getLeft() + offsetx;
                lp.topMargin = getTop() + offsety;
                setLayoutParams(lp);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
