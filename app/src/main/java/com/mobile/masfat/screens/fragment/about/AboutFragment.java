package com.mobile.masfat.screens.fragment.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends Fragment {
    @BindView(R.id.txt_about)
    RegularTextView txtAbout;
    @BindView(R.id.txt_about2)
    RegularTextView txtAbout2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtAbout.setText(getText(R.string.lorem));
        txtAbout2.setText(getText(R.string.lorem));
    }
}
