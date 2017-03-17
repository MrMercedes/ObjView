package com.example.hp0331.objview.activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp0331.objview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.btn_cancel)
    Button mBtnCancel;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.pointview)
    PonitView mPointview;
    private ValueAnimator repeatAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
    }

    private ValueAnimator doRepeatAnim() {
//        ValueAnimator animator = ValueAnimator.ofInt(0,400);
//        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int)animation.getAnimatedValue();
//                mTv.layout(mTv.getLeft(),curValue,mTv.getRight(),curValue+mTv.getHeight());
//                int curValue = (int)animation.getAnimatedValue();
//                mTv.setBackgroundColor(curValue);
                char text = (char) animation.getAnimatedValue();
                mTv.setText(String.valueOf(text));
            }
        });
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(3000);
//        animator.setInterpolator(new LinearInterpolator());

//        animator.setEvaluator(new ArgbEvaluator());
        animator.setEvaluator(new CharEvaluator());
        animator.start();
        return animator;
    }

    @OnClick({R.id.btn, R.id.btn_cancel, R.id.tv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                mPointview.doPointAnim();
//                repeatAnimator = doRepeatAnim();
                break;
            case R.id.btn_cancel:
//                repeatAnimator.cancel();
                break;
            case R.id.tv:
                Toast.makeText(this, "wwwwww", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @OnClick(R.id.pointview)
    public void onClick() {
    }
}
