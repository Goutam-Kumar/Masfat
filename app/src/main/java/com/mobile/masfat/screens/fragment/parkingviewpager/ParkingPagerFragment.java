package com.mobile.masfat.screens.fragment.parkingviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.customwidget.BoldButton;
import com.mobile.masfat.customwidget.BoldTextView;
import com.mobile.masfat.customwidget.RegularTextView;
import com.mobile.masfat.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkingPagerFragment extends Fragment {
    private static final String IMAGE = "https://assets.simpleviewinc.com/simpleview/image/upload/c_fit,w_1440,h_900/crm/miamifl/Dolphin-mall-main-1440x9000-76d7c4ac5056a36_76d7c5dd-5056-a36a-0bf9d8050a5d518f.jpg";
    @BindView(R.id.txt_facilities_num)
    BoldTextView txtFacilitiesNum;
    @BindView(R.id.img_parking)
    ImageView imgParking;
    @BindView(R.id.txt_parking_name)
    RegularTextView txtParkingName;
    @BindView(R.id.txt_desc)
    RegularTextView txtDesc;
    @BindView(R.id.txt_distance)
    RegularTextView txtDistance;
    @BindView(R.id.card_parking)
    CardView cardParking;
    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.btn_more_info)
    BoldButton btnMoreInfo;
    @BindView(R.id.lin_map)
    LinearLayout linMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager_parking_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CommonUtil.setPictureWithCache(getActivity(),imgParking,IMAGE);

        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getActivity());
                final View customDialog = factory.inflate(R.layout.dlg_change_password_notification, null);
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.Theme_D1NoTitleDim);
                builder.setView(customDialog);
                AlertDialog alert= AppHelper.blurBehindAlertDlg(getActivity(),builder);
                alert.show();
            }
        });
    }
}
