package com.mobile.masfat.baseactivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;
import com.mobile.masfat.screens.fragment.FeedbackFragment;
import com.mobile.masfat.screens.fragment.about.AboutFragment;
import com.mobile.masfat.screens.fragment.faqs.FaqsFragment;
import com.mobile.masfat.screens.fragment.language.LanguageFragment;
import com.mobile.masfat.screens.fragment.listfragment.ListFragment;
import com.mobile.masfat.screens.fragment.mapview.MapViewFragment;
import com.mobile.masfat.screens.fragment.myaccount.MyAccountFragment;
import com.mobile.masfat.screens.fragment.mybooking.MyBookingFragment;
import com.mobile.masfat.screens.fragment.notification.FragmentNotification;
import com.mobile.masfat.screens.fragment.parkingviewpager.ParkingPagerFragment;
import com.mobile.masfat.screens.fragment.parkingviewpager.ParkingViewPagerFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    @BindView(R.id.header)
    RelativeLayout header;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.img_menu)
    ImageView imgMenu;
    @BindView(R.id.txt_header)
    RegularTextView txtHeader;
    @BindView(R.id.nav_drawer)
    DrawerLayout navDrawer;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    @BindView(R.id.txt_user_name)
    RegularTextView txtUserName;
    @BindView(R.id.txt_user_email)
    RegularTextView txtUserEmail;
    @BindView(R.id.rcv_drawer_menu)
    RecyclerView rcvDrawerMenu;


    int[] menuItems = {R.string.home,R.string.my_account, R.string.my_booking, R.string.find_my_car, R.string.notifications, R.string.about, R.string.feedback, R.string.faqs, R.string.languages, R.string.logout};
    int[] menuIcons = {R.drawable.home,R.drawable.my_account, R.drawable.my_booking, R.drawable.find_my_car, R.drawable.notifications, R.drawable.about, R.drawable.feedback, R.drawable.faq, R.drawable.languages, R.drawable.logout};
    private DrawerMenuAdapter mDrawerMenuAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();

        addFragment(new ParkingViewPagerFragment(), getString(R.string.list_view_parking));
        mDrawerMenuAdapter = new DrawerMenuAdapter(this,menuItems,menuIcons);
        rcvDrawerMenu.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        rcvDrawerMenu.setAdapter(mDrawerMenuAdapter);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!navDrawer.isDrawerOpen(Gravity.RIGHT)) {
                    navDrawer.openDrawer(Gravity.RIGHT);
                } else {
                    navDrawer.closeDrawer(Gravity.RIGHT);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (navDrawer.isDrawerOpen(Gravity.RIGHT)) {
            navDrawer.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

    public void addFragment(Fragment fragment, String headerTitle) {
        txtHeader.setText(headerTitle);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.frame_container, fragment);
        mFragmentTransaction.commit();
    }

    public void replaceFragmentWithStack(Fragment fragment, String headerTitle) {
        txtHeader.setText(headerTitle);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame_container, fragment);
        mFragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        mFragmentTransaction.commit();
    }

    public void replaceFragmentWithOutStack(Fragment fragment, String headerTitle) {
        txtHeader.setText(headerTitle);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame_container, fragment);
        mFragmentTransaction.commit();
    }

    public void clearHeaderTitle() {
        txtHeader.setText("");
    }
    public void setHeaderTitle(String title){
        txtHeader.setText(title);
    }
    public void onDrawerMenuSelected(int position){
        Fragment fragment = null;
        String headerTitle = "";
        switch (position){
            case 0:
                fragment = new ParkingViewPagerFragment();
                headerTitle = getString(R.string.list_view_parking);
                break;
            case 1:
                fragment = new MyAccountFragment();
                headerTitle = getString(R.string.my_account);
                break;
            case 2:
                fragment = new MyBookingFragment();
                headerTitle = getString(R.string.my_booking);
                break;
            case 3:
                fragment = new MapViewFragment();
                headerTitle = getString(R.string.my_booking);
                break;
            case 4:
                fragment = new FragmentNotification();
                headerTitle = getString(R.string.notifications);
                break;
            case 5:
                fragment = new AboutFragment();
                headerTitle = getString(R.string.about_masfat);
                break;
            case 6:
                fragment = new FeedbackFragment();
                headerTitle = getString(R.string.feedback);
                break;
            case 7:
                fragment = new FaqsFragment();
                headerTitle = getString(R.string.faqs);
                break;
            case 8:
                fragment = new LanguageFragment();
                headerTitle = getString(R.string.change_lang);
                break;
            case 9:
                break;
        }
        if (fragment != null)
        replaceFragmentWithOutStack(fragment,headerTitle);
        if (!navDrawer.isDrawerOpen(Gravity.RIGHT)) {
            navDrawer.openDrawer(Gravity.RIGHT);
        } else {
            navDrawer.closeDrawer(Gravity.RIGHT);
        }
    }
}
