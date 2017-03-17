package com.example.hp0331.objview.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.hp0331.objview.R;

/**
 * Created by Aaron.zhang
 * at  2017/3/9.
 */

public class AvatorViewDemo extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    public AvatorViewDemo(Context context) {
        super(context);
        initView();
    }

    public AvatorViewDemo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AvatorViewDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView(){
        mBitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.touxiang);
        mPaint=new Paint();
        mBitmapShader=new BitmapShader(mBitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix=new Matrix();
        float scale=(float) getWidth()/mBitmap.getWidth();
        matrix.setScale(scale,scale);
        mBitmapShader.setLocalMatrix(matrix);
        mPaint.setShader(mBitmapShader);

        float half=getWidth()/2;
        canvas.drawCircle(half,half,getWidth()/2,mPaint);

    }
}
