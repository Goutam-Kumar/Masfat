package com.mobile.masfat.screens.fragment.topuphistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;

public class TopUpHistoryAdapter extends RecyclerView.Adapter<TopUpHistoryAdapter.TopupHolder> {
    Context context;

    public TopUpHistoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TopupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TopupHolder(LayoutInflater.from(context).inflate(R.layout.item_topup_history,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TopupHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class TopupHolder extends RecyclerView.ViewHolder {

        public TopupHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
