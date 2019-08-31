package com.mobile.masfat.screens.fragment.listfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.BoldTextView;
import com.mobile.masfat.screens.fragment.facilities.FacilitiesFragment;
import com.mobile.masfat.screens.fragment.parkingbooking.ParkingBookingFragment;
import com.mobile.masfat.screens.fragment.parkingviewpager.ParkingViewPagerFragment;
import com.mobile.masfat.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragmentAdapter extends RecyclerView.Adapter<ListFragmentAdapter.ListViewHolder> {
    Context context;
    String[] images = {
            "https://thumbs.dreamstime.com/b/view-pioneer-place-shopping-mall-downtown-portland-portland-oregon-usa-april-view-pioneer-place-shopping-mall-115847680.jpg",
            "https://www.incimages.com/uploaded_files/image/970x450/mall-1940x900_29316.jpg",
            "https://assets.simpleviewinc.com/simpleview/image/upload/c_fit,w_1440,h_900/crm/miamifl/Dolphin-mall-main-1440x9000-76d7c4ac5056a36_76d7c5dd-5056-a36a-0bf9d8050a5d518f.jpg",
            "https://cdn.brigadegroup.com/properties/gallery/15331262635b61a677cf223.jpg"};
    public ListFragmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_view, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        CommonUtil.setPictureWithCache(context,holder.imgParking,images[position]);
        holder.imgParkingInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) context;
                baseActivity.replaceFragmentWithStack(new FacilitiesFragment(),context.getString(R.string.facilities));
            }
        });

        holder.imgParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) context).replaceFragmentWithStack(new ParkingBookingFragment(),context.getString(R.string.parking_booking));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_time)
        BoldTextView txtTime;
        @BindView(R.id.txt_parking_name)
        BoldTextView txtParkingName;
        @BindView(R.id.txt_distance)
        BoldTextView txtDistance;
        @BindView(R.id.img_parking)
        ImageView imgParking;
        @BindView(R.id.img_parking_info)
        ImageView imgParkingInfo;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
