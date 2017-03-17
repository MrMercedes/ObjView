package com.example.hp0331.objview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.example.hp0331.objview.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Bell2Activity extends AppCompatActivity {

    @BindView(R.id.bellview2)
    BellView2 mBellview2;
    @BindView(R.id.activity_bell2)
    RelativeLayout mActivityBell2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell2);
        ButterKnife.bind(this);
        mBellview2.startAnimator();
    }
}
