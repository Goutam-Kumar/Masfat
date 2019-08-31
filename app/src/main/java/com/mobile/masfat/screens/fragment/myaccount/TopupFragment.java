package com.mobile.masfat.screens.fragment.myaccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.BoldButton;
import com.mobile.masfat.screens.fragment.addtopup.AddTopupFragment;
import com.mobile.masfat.screens.fragment.topuphistory.TopupHistoryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopupFragment extends Fragment {
    @BindView(R.id.img_add)
    ImageView imgAdd;
    @BindView(R.id.btn_history)
    BoldButton btnHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topup, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) getActivity()).replaceFragmentWithStack(new AddTopupFragment(),"");
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new TopupHistoryFragment(),getString(R.string.top_up));
            }
        });
    }
}
