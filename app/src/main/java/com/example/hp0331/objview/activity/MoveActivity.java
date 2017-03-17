package com.example.hp0331.objview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hp0331.objview.R;
import com.example.hp0331.objview.activity.view.MoveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoveActivity extends AppCompatActivity {
    @BindView(R.id.mv_moveview)
    MoveView mMvMoveview;
    @BindView(R.id.btn_choose)
    Button mBtnChoose;
//
//    private MoveView mMoveView;
//    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        ButterKnife.bind(this);
//        mButton=(Button)findViewById(R.id.btn_choose);
//        mMoveView=(MoveView)findViewById(R.id.mv_moveview);
//        mButton.setOnClickListener(this);
//        mMoveView.setOnClickListener(this);
    }
    public void set(View v) {
        mMvMoveview.setBackgroundColor(Color.RED);    }
    @OnClick({R.id.mv_moveview, R.id.btn_choose})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mv_moveview:
                break;
            case R.id.btn_choose:
              set(view);
                break;
        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btn_choose:
//                mMoveView.setBackgroundColor(Color.RED);
//                break;
//            case R.id.mv_moveview:
//                break;
//        }
//    }
}
