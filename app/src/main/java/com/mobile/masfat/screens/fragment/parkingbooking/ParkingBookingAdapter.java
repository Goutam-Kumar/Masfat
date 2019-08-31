package com.mobile.masfat.screens.fragment.parkingbooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.BoldTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkingBookingAdapter extends RecyclerView.Adapter<ParkingBookingAdapter.ParkingHolder> {
    Context context;


    public ParkingBookingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ParkingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParkingHolder(LayoutInflater.from(context).inflate(R.layout.item_parking_available, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ParkingHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.left_check)
        CheckBox leftCheck;
        @BindView(R.id.txt_left_parking)
        BoldTextView txtLeftParking;
        @BindView(R.id.right_check)
        CheckBox rightCheck;
        @BindView(R.id.txt_right_parking)
        BoldTextView txtRightParking;

        public ParkingHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
