package com.mobile.masfat.screens.fragment.listfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.RegularEditText;
import com.mobile.masfat.screens.fragment.mapview.MapViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListFragment extends Fragment {
    @BindView(R.id.txt_destination)
    RegularEditText txtDestination;
    @BindView(R.id.img_map)
    ImageView imgMap;
    @BindView(R.id.rcv_list_parking)
    RecyclerView rcvListParking;

    private ListFragmentAdapter listFragmentAdapter = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listFragmentAdapter = new ListFragmentAdapter(getActivity());
        rcvListParking.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        rcvListParking.setAdapter(listFragmentAdapter);
        imgMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) getActivity()).replaceFragmentWithOutStack(new MapViewFragment(),getString(R.string.get_direction));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        ((BaseActivity) getActivity()).clearHeaderTitle();
    }
}
