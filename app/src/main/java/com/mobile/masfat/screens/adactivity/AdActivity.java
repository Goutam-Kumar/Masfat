package com.mobile.masfat.screens.adactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdActivity extends AppCompatActivity {

    @BindView(R.id.img_ad)
    ImageView imgAd;
    @BindView(R.id.btn_skip)
    Button btnSkip;
    private static final String IMAGE_CAR = "https://images.unsplash.com/photo-1504215680853-026ed2a45def?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);
        CommonUtil.setPictureWithCache(this,imgAd,IMAGE_CAR);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdActivity.this, BaseActivity.class));
            }
        });
    }
}
