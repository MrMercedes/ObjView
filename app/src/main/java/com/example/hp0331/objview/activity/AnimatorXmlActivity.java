package com.example.hp0331.objview.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hp0331.objview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorXmlActivity extends AppCompatActivity {

    @BindView(R.id.menu)
    Button mMenu;
    @BindView(R.id.item1)
    Button mItem1;
    @BindView(R.id.item2)
    Button mItem2;
    @BindView(R.id.item3)
    Button mItem3;
    @BindView(R.id.item4)
    Button mItem4;
    @BindView(R.id.item5)
    Button mItem5;

    private boolean menuopen;
    private String TAG="Animator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_xml);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.menu,R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                if (!menuopen){
                    menuopen=true;
                    doAnimatorOpen(mItem1,0,5,300);
                    doAnimatorOpen(mItem2,1,5,300);
                    doAnimatorOpen(mItem3,2,5,300);
                    doAnimatorOpen(mItem4,3,5,300);
                    doAnimatorOpen(mItem5,4,5,300);
                    Log.d(TAG,"OPEN");
                }else {
                    menuopen=false;
                    doAnimateClose(mItem1,0,5,300);
                    doAnimateClose(mItem2,1,5,300);
                    doAnimateClose(mItem3,2,5,300);
                    doAnimateClose(mItem4,3,5,300);
                    doAnimateClose(mItem5,4,5,300);
                    Log.d(TAG,"CLOSE");
                }
                break;
            case R.id.item1:
                Log.d(TAG,"item1");
//                clickItem(0);
                break;
            case R.id.item2:
//                clickItem(1);
                Log.d(TAG,"item2");
                break;
            case R.id.item3:
//                clickItem(2);
                Log.d(TAG,"item3");
                break;
            case R.id.item4:
//                clickItem(3);
                Log.d(TAG,"item4");
                break;
            case R.id.item5:
//                clickItem(4);
                Log.d(TAG,"item5");
                break;
        }
    }
    public void clickItem(int index){
        switch (index){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
    public void doAnimatorOpen(final View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / 4 * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "TranslationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "TranslationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "csaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1)

        );
        Log.d(TAG,"open"+index);
        animatorSet.setDuration(500).start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private void doAnimateClose(final View view,final int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(1 * 500).start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               if (view.getVisibility()==View.VISIBLE){
                   view.setVisibility(View.GONE);
                   Log.d(TAG,index+"set gone");
               }
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
