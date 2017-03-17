package com.example.hp0331.objview.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.hp0331.objview.R;

/**
 * Created by Aaron.zhang
 * at  2017/3/9.
 */

public class ShadowLayerView extends View{
    private Paint mPaint = new Paint();
    private Bitmap mDogBmp;
    public ShadowLayerView(Context context) {
        super(context);
        initview();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(25);
        mPaint.setShadowLayer(1,10,10,Color.GRAY);
        mDogBmp= BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("中华人民共和国",100,100,mPaint);
        canvas.drawCircle(200,200,50,mPaint);
        canvas.drawBitmap(mDogBmp,null,new Rect(200,300,200+mDogBmp.getWidth(),300+mDogBmp.getHeight()),mPaint);
    }
}
