package com.mobile.masfat.screens.fragment.addtopup;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentOptionAdapter extends RecyclerView.Adapter<PaymentOptionAdapter.PaymentOptionHolder> {
    int[] paymentOption = {R.drawable.card, R.drawable.k_net, R.drawable.paypal};
    Context context;


    public PaymentOptionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentOptionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PaymentOptionHolder(LayoutInflater.from(context).inflate(R.layout.item_payment_option, null));
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentOptionHolder holder, int position) {
        holder.imgPayment.setBackgroundResource(paymentOption[position]);
        holder.linPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linPayment.setBackground(ContextCompat.getDrawable(context,R.drawable.orange_border));
                holder.imgPayment.setColorFilter(ContextCompat.getColor(context, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paymentOption.length;
    }

    public class PaymentOptionHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_payment)
        ImageView imgPayment;
        @BindView(R.id.lin_payment)
        LinearLayout linPayment;
        public PaymentOptionHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
