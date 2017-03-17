package com.example.hp0331.objview.activity;

import android.animation.Animator;
import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by Aaron.zhang
 * at  2017/2/28.
 */

public class PonitView extends View{
    private Point mPoint;
    public PonitView(Context context) {
        super(context);
    }

    public PonitView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PonitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint!=null){
            Paint paint=new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getRadius(),paint);
        }
    }
    public void  doPointAnim(){
        final ValueAnimator valueAnimator=ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint=(Point)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }
}
