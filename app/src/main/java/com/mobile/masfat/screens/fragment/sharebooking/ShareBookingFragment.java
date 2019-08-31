package com.mobile.masfat.screens.fragment.sharebooking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.RegularTextView;
import com.mobile.masfat.screens.fragment.sharedhistory.SharedHistoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShareBookingFragment extends Fragment {

    @BindView(R.id.rcv_share_booking)
    RecyclerView rcvShareBooking;
    @BindView(R.id.txt_topup_more)
    RegularTextView txtTopupMore;
    ShareBookingAdapter shareBookingAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_share_booking, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shareBookingAdapter = new ShareBookingAdapter(getActivity());
        rcvShareBooking.setAdapter(shareBookingAdapter);
        rcvShareBooking.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        txtTopupMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getActivity()).replaceFragmentWithOutStack(new SharedHistoryFragment(),getString(R.string.shared_history));
            }
        });
    }
}
