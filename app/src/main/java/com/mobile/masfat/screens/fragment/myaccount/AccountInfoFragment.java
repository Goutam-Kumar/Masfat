package com.mobile.masfat.screens.fragment.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.RegularTextView;
import com.mobile.masfat.screens.fragment.topuphistory.TopupHistoryFragment;
import com.mobile.masfat.screens.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AccountInfoFragment extends Fragment {
    @BindView(R.id.txt_change_pass)
    RegularTextView txtChangePass;
    @BindView(R.id.txt_topup_history)
    RegularTextView txtTopupHistory;
    @BindView(R.id.txt_booking)
    RegularTextView txtBooking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_info, container, false);
        ButterKnife. bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                final View customDialog = factory.inflate(R.layout.dlg_change_password, null);
                TextView txtPassword = customDialog.findViewById(R.id.txt_password);
                TextView txt_conf_password = customDialog.findViewById(R.id.txt_conf_password);
                Button btn_chng_pass = customDialog.findViewById(R.id.btn_chng_pass);
                btn_chng_pass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayChangePasswordConfirm();
                    }
                });
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
                builder.setView(customDialog);
                AlertDialog alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
                alert.show();
            }
        });

        txtTopupHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getActivity()).replaceFragmentWithStack(new TopupHistoryFragment(),getString(R.string.top_up_history));
            }
        });
    }

    private void displayChangePasswordConfirm() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View customDialog = factory.inflate(R.layout.dlg_change_password_notification, null);
        Button btn_login = customDialog.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
        builder.setView(customDialog);
        AlertDialog alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
        alert.show();
    }
}
