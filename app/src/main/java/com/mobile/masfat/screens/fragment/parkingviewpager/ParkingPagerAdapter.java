package com.mobile.masfat.screens.fragment.parkingviewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ParkingPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 4;

    public ParkingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ParkingPagerFragment();
            case 1:
                return new ParkingPagerFragment();
            case 2:
                return new ParkingPagerFragment();
            case 3:
                return new ParkingPagerFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
