package com.mobile.masfat.screens.fragment.facilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.BoldTextView;
import com.mobile.masfat.customwidget.RegularTextView;
import com.mobile.masfat.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FacilitiesFragment extends Fragment {
    private static final String IMAGE = "https://www.incimages.com/uploaded_files/image/970x450/mall-1940x900_29316.jpg";
    @BindView(R.id.img_parking)
    ImageView imgParking;
    @BindView(R.id.txt_parking_name)
    BoldTextView txtParkingName;
    @BindView(R.id.txt_distance)
    RegularTextView txtDistance;
    @BindView(R.id.txt_dsc)
    RegularTextView txtDsc;
    @BindView(R.id.rating_parking)
    RatingBar ratingParking;
    @BindView(R.id.rcv_parking)
    RecyclerView rcvParking;
    @BindView(R.id.mid_line)
    View midLine;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facilities, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        midLine.setVisibility(View.GONE);
        CommonUtil.setPictureWithCache(getActivity(),imgParking,IMAGE);
    }
}
