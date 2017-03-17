package com.example.hp0331.objview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.hp0331.objview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BellActivity extends AppCompatActivity {

    @BindView(R.id.btn_reset)
    Button mBtnReset;
    @BindView(R.id.bellview)
    BellView mBellview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_reset)
    public void onClick() {
        mBellview.reset();
    }
}
