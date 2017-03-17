package com.example.hp0331.objview.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Aaron.zhang
 * at  2017/3/2.
 */

public class BellView extends View {
    private Path mPath=new Path();
    private float mPrex,mPrey;
    public BellView(Context context) {
        super(context);
    }

    public BellView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BellView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);

        canvas.drawPath(mPath,paint);
    }

    public void reset(){
        mPath.reset();
        postInvalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(),event.getY());
                mPrex=event.getX();
                mPrey=event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endx=(mPrex+event.getX())/2;
                float endy=(mPrey+event.getY())/2;
                mPath.quadTo(mPrex,mPrey,endx,endy);
                mPrex=event.getX();
                mPrey=event.getY();
                invalidate();
                break;
        }
        return super.onTouchEvent(event);

    }
}
