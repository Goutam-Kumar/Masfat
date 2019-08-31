package com.mobile.masfat.screens.fragment.faqs;

import android.content.Context;
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

import butterknife.BindView;
import butterknife.ButterKnife;

public class FaqsFragment extends Fragment {
    @BindView(R.id.rcv_faqs)
    RecyclerView rcvFaqs;
    FaqsAdapter faqsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        faqsAdapter = new FaqsAdapter(getActivity());
        rcvFaqs.setAdapter(faqsAdapter);
        rcvFaqs.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
    }
}
