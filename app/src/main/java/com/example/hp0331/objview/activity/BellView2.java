package com.example.hp0331.objview.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Aaron.zhang
 * at  2017/3/2.
 */

public class BellView2 extends View{
    private Paint mPaint;
    private Path mPath;
    private int mItemWaveLength=400;
    private int dx;


    public BellView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPath=new Path();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        int originy=300;
        int halfWabelen=mItemWaveLength/2;
        mPath.moveTo(-mItemWaveLength+dx,originy);
        for (int i=-mItemWaveLength;i<=getWidth()+mItemWaveLength;i+=mItemWaveLength){
            mPath.rQuadTo(halfWabelen/2,-100,halfWabelen,0);
            mPath.rQuadTo(halfWabelen/2,100,halfWabelen,0);
        }
        mPath.lineTo(getWidth(),getHeight());
        mPath.lineTo(0,getHeight());
        mPath.close();

        canvas.drawPath(mPath,mPaint);
    }
    public void startAnimator(){
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,mItemWaveLength);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx=(int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }
}
