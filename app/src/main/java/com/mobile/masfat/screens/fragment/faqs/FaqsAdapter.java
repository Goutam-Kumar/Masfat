package com.mobile.masfat.screens.fragment.faqs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.BoldTextView;
import com.mobile.masfat.customwidget.RegularTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FaqsAdapter extends RecyclerView.Adapter<FaqsAdapter.FaqHolder> {
    String[] faqTitleAr = {"What if I will not reach on spot on time", "What about refund", "Tell me about parking spot"};
    Context context;

    public FaqsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FaqHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FaqHolder(LayoutInflater.from(context).inflate(R.layout.item_faq, null));
    }

    @Override
    public void onBindViewHolder(@NonNull FaqHolder holder, int position) {
        holder.txtNumber.setText(String.valueOf(position+1));
        holder.faqTitle.setText(faqTitleAr[position]);
        holder.faqDesc.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    }

    @Override
    public int getItemCount() {
        return faqTitleAr.length;
    }

    public class FaqHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_number)
        BoldTextView txtNumber;
        @BindView(R.id.faq_title)
        RegularTextView faqTitle;
        @BindView(R.id.faq_desc)
        RegularTextView faqDesc;

        public FaqHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
