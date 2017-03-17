package com.example.hp0331.objview.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp0331.objview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.tv_1)
    TextView mTv1;
    @BindView(R.id.tv_2)
    TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                doPlaySequentiallyAnimator();
                break;

        }
    }
    private void doPlaySequentiallyAnimator(){
        ObjectAnimator objectAnimator1bg=ObjectAnimator.ofInt(mTv1,"BackgroundColor",  0xffff00ff, 0xffffff00, 0xffff00ff);
        ObjectAnimator objectAnimator1y=ObjectAnimator.ofFloat(mTv1,"TranslationY",0,300,0);
        ObjectAnimator objectAnimator2y=ObjectAnimator.ofFloat(mTv2,"TranslationY",0,400,0);
        AnimatorSet animatorSet=new AnimatorSet();
//        animatorSet.playSequentially(objectAnimator1bg,objectAnimator1y,objectAnimator2y);
        animatorSet.playTogether(objectAnimator1bg,objectAnimator1y,objectAnimator2y);

        animatorSet.setDuration(1000);
        animatorSet.start();


    }
}
