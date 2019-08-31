package com.mobile.masfat.screens.fragment.sharedhistory;

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
import com.mobile.masfat.customwidget.RegularButton;
import com.mobile.masfat.screens.fragment.parkingviewpager.ParkingViewPagerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SharedHistoryFragment extends Fragment {
    @BindView(R.id.rcv_shared_history)
    RecyclerView rcvSharedHistory;
    @BindView(R.id.btn_my_acc)
    RegularButton btnMyAcc;
    SharedHistoryAdapter sharedHistoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shared_history, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnMyAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity)getActivity()).replaceFragmentWithOutStack(new ParkingViewPagerFragment(),getString(R.string.list_view_parking));
            }
        });
        sharedHistoryAdapter = new SharedHistoryAdapter(getActivity());
        rcvSharedHistory.setAdapter(sharedHistoryAdapter);
        rcvSharedHistory.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
    }
}
