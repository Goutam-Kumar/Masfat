package com.mobile.masfat.screens.fragment.topuphistory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopupHistoryFragment extends Fragment {
    @BindView(R.id.rcv_topup_history)
    RecyclerView rcvTopupHistory;
    @BindView(R.id.txt_topup_more)
    RegularTextView txtTopupMore;
    TopUpHistoryAdapter topUpHistoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topup_history, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtTopupMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        topUpHistoryAdapter = new TopUpHistoryAdapter(getActivity());
        rcvTopupHistory.setAdapter(topUpHistoryAdapter);
    }
}
