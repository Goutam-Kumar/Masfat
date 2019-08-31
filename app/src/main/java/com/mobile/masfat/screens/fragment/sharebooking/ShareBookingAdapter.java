package com.mobile.masfat.screens.fragment.sharebooking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.BoldButton;
import com.mobile.masfat.customwidget.BoldTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShareBookingAdapter extends RecyclerView.Adapter<ShareBookingAdapter.ShareHolder> {
    Context context;


    public ShareBookingAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShareHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShareHolder(LayoutInflater.from(context).inflate(R.layout.item_share_booking, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ShareHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ShareHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.chk_parking)
        CheckBox chkParking;
        @BindView(R.id.txt_name)
        BoldTextView txtName;
        @BindView(R.id.btn_share)
        BoldButton btnShare;
        public ShareHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
