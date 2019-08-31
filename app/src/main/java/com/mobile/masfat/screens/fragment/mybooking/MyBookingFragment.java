package com.mobile.masfat.screens.fragment.mybooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.screens.fragment.parkingviewpager.ParkingViewPagerFragment;
import com.mobile.masfat.screens.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBookingFragment extends Fragment {
    @BindView(R.id.card_personal_info)
    CardView cardPersonalInfo;
    @BindView(R.id.acc_info)
    CardView accInfo;
    @BindView(R.id.card_topup)
    CardView cardTopup;
    @BindView(R.id.card_booking_history)
    CardView cardBookingHistory;
    @BindView(R.id.lin_destination)
    LinearLayout linDestination;
    @BindView(R.id.lin_cancel_booking)
    LinearLayout linCancelBooking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_booking, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        linCancelBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelBookingConfirmation();
            }
        });
    }

    private void cancelBookingConfirmation() {
        AlertDialog alert = null;
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View customDialog = factory.inflate(R.layout.dlg_booking_cancel_confirmation, null);
        Button btn_yes = customDialog.findViewById(R.id.btn_yes);
        Button btn_no = customDialog.findViewById(R.id.btn_no);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookingCancelled();
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
        builder.setView(customDialog);
        alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
        alert.show();
    }

    private void bookingCancelled() {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        final View customDialog = factory.inflate(R.layout.dlg_booking_cancelled, null);
        Button btn_home = customDialog.findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null)
                    ((BaseActivity)getActivity()).replaceFragmentWithOutStack(new ParkingViewPagerFragment(),"");
            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
        builder.setView(customDialog);
        AlertDialog alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
        alert.show();
    }
}
