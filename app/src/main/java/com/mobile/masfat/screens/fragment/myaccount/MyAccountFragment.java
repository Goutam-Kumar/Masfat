package com.mobile.masfat.screens.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.screens.fragment.sharebooking.ShareBookingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAccountFragment extends Fragment {

    @BindView(R.id.lin_personal_info)
    LinearLayout linPersonalInfo;
    @BindView(R.id.lin_acc_info)
    LinearLayout linAccInfo;
    @BindView(R.id.lin_top_up)
    LinearLayout linTopUp;
    @BindView(R.id.lin_booking_history)
    LinearLayout linBookingHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_account, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new PersonalInfoFragment(),getString(R.string.personal_info));
            }
        });

        linAccInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new AccountInfoFragment(),getString(R.string.account_info));
            }
        });

        linTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new TopupFragment(),getString(R.string.top_up));
            }
        });

        linBookingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new ShareBookingFragment(),getString(R.string.share_booking));
            }
        });
    }
}
