package com.mobile.masfat.screens.adactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdActivity extends AppCompatActivity {

    @BindView(R.id.img_ad)
    ImageView imgAd;
    @BindView(R.id.btn_skip)
    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdActivity.this, BaseActivity.class));
            }
        });
    }
}
