package com.mobile.masfat.screens.fragment.parkingviewpager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.RegularEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkingViewPagerFragment extends Fragment {

    @BindView(R.id.txt_destination)
    RegularEditText txtDestination;
    @BindView(R.id.view_pager_parking)
    ViewPager viewPagerParking;
    private ParkingPagerAdapter mParkingPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parking_view_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        BaseActivity baseActivity = (BaseActivity) getActivity();
        baseActivity.setHeaderTitle(getString(R.string.list_view_parking));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mParkingPagerAdapter = new ParkingPagerAdapter(getChildFragmentManager());
        viewPagerParking.setAdapter(mParkingPagerAdapter);
        setViewPagerPreview(viewPagerParking);
    }

    public void setViewPagerPreview(ViewPager viewPager) {
        viewPager.setClipToPadding(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int paddingToSet = width/8;
        viewPager.setPadding(paddingToSet, 0, paddingToSet, 0);
        viewPager.setPageMargin(5);
    }
}
