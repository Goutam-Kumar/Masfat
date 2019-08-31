package com.mobile.masfat.screens.fragment.parkingbooking;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.masfat.R;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.BoldTextView;
import com.mobile.masfat.customwidget.RegularTextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParkingBookingFragment extends Fragment {
    @BindView(R.id.txt_name)
    BoldTextView txtName;
    @BindView(R.id.lin_date_time)
    LinearLayout linDateTime;
    @BindView(R.id.lin_duration)
    LinearLayout linDuration;
    @BindView(R.id.rcv_parking)
    RecyclerView rcvParking;
    @BindView(R.id.mid_line)
    View midLine;
    @BindView(R.id.btn_next)
    RegularTextView btnNext;
    String date_time = "";
    @BindView(R.id.txt_date_time)
    RegularTextView txtDateTime;
    @BindView(R.id.txt_duration)
    RegularTextView txtDuration;
    @BindView(R.id.spin_duration)
    Spinner spinDuration;
    String[] durationArray = {"Select Duration","1:00 hr","2:00 hrs","3:00 hrs","4:00 hrs"};
    ParkingBookingAdapter parkingBookingAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parking_booking, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, durationArray);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDuration.setAdapter(spinnerArrayAdapter);
        parkingBookingAdapter = new ParkingBookingAdapter(getActivity());
        rcvParking.setAdapter(parkingBookingAdapter);
        rcvParking.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        linDuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinDuration.performClick();
            }
        });
        spinDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtDuration.setText(durationArray[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        ((BaseActivity) getActivity()).setHeaderTitle(getString(R.string.parking_booking));
    }

    private void datePicker() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                tiemPicker();
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void tiemPicker() {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txtDateTime.setText(date_time + " " + hourOfDay + ":" + minute);
            }
        }, mHour, mMinute, false);
        timePickerDialog.show();
    }
}
