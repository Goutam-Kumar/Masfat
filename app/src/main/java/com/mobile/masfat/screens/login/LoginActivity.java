package com.mobile.masfat.screens.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.customwidget.BoldButton;
import com.mobile.masfat.customwidget.RegularEditText;
import com.mobile.masfat.screens.adactivity.AdActivity;
import com.mobile.masfat.screens.signup.SignUpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mobile.masfat.apphelper.AppHelper.fastblur;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.txt_email)
    RegularEditText txtEmail;
    @BindView(R.id.txt_password)
    RegularEditText txtPassword;
    @BindView(R.id.btn_signin)
    BoldButton btnSignin;
    @BindView(R.id.btn_signup)
    BoldButton btnSignup;
    @BindView(R.id.img_facebook)
    ImageView imgFacebook;
    @BindView(R.id.img_google)
    ImageView imgGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*LayoutInflater factory = LayoutInflater.from(LoginActivity.this);
                final View customDialog = factory.inflate(R.layout.dlg_change_password_notification, null);
                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this,R.style.Theme_D1NoTitleDim);
                builder.setView(customDialog);
                AlertDialog alert= AppHelper.blurBehindAlertDlg(LoginActivity.this,builder);
                alert.show();*/
                startActivity(new Intent(LoginActivity.this, AdActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }
}
