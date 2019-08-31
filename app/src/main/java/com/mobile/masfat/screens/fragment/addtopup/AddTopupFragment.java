package com.mobile.masfat.screens.fragment.addtopup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.customwidget.RegularButton;
import com.mobile.masfat.customwidget.RegularEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTopupFragment extends Fragment {

    @BindView(R.id.txt_amount)
    RegularEditText txtAmount;
    @BindView(R.id.rcv_payment_option)
    RecyclerView rcvPaymentOption;
    @BindView(R.id.btn_add_now)
    RegularButton btnAddNow;
    PaymentOptionAdapter paymentOptionAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_topup, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        paymentOptionAdapter = new PaymentOptionAdapter(getActivity());
        rcvPaymentOption.setAdapter(paymentOptionAdapter);
        rcvPaymentOption.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        btnAddNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
