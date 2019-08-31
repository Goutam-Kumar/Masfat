package com.mobile.masfat.screens.fragment.sharedhistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;

public class SharedHistoryAdapter extends RecyclerView.Adapter<SharedHistoryAdapter.HistoryHolder> {
    Context context;
    @BindView(R.id.txt_name)
    RegularTextView txtName;
    @BindView(R.id.txt_date)
    RegularTextView txtDate;

    public SharedHistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryHolder(LayoutInflater.from(context).inflate(R.layout.item_shared_history, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
