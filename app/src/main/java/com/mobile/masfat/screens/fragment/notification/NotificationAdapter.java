package com.mobile.masfat.screens.fragment.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {
    Context context;
    String[] timeArray = {"10:26","2 Days Ago","1 week Ago"};
    String[] title = {"Avenues Mall","360 Mall", "Marina Mall"};
    String[] desc = {"You exceeded time limit and you will be charged for the additional time.",
    "We have an exciting offers for you near to you.","We have an exciting offers for you near to you."};

    public NotificationAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationHolder(LayoutInflater.from(context).inflate(R.layout.item_notification, null));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationHolder holder, int position) {
        holder.txtTime.setText(timeArray[position]);
        holder.txtDate.setText(title[position]);
        holder.txtType.setText(desc[position]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class NotificationHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_time)
        RegularTextView txtTime;
        @BindView(R.id.txt_date)
        RegularTextView txtDate;
        @BindView(R.id.txt_type)
        RegularTextView txtType;

        public NotificationHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
