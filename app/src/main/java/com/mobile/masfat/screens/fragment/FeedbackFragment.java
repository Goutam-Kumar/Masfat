package com.mobile.masfat.screens.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.BoldButton;
import com.mobile.masfat.customwidget.RegularEditText;
import com.mobile.masfat.screens.fragment.listfragment.ListFragment;
import com.mobile.masfat.screens.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedbackFragment extends Fragment {
    @BindView(R.id.txt_name)
    RegularEditText txtName;
    @BindView(R.id.txt_email)
    RegularEditText txtEmail;
    @BindView(R.id.txt_msg)
    RegularEditText txtMsg;
    @BindView(R.id.btn_send)
    BoldButton btnSend;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackSuibmitPopup();
            }
        });
    }

    private void feedbackSuibmitPopup() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View customDialog = factory.inflate(R.layout.dlg_feedback_notification, null);
        Button btn_home = customDialog.findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithOutStack(new ListFragment(),"");
            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
        builder.setView(customDialog);
        AlertDialog alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
        alert.show();
    }
}
