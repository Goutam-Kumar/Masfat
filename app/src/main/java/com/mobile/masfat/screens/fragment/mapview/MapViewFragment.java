package com.mobile.masfat.screens.fragment.mapview;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobile.masfat.R;
import com.mobile.masfat.apphelper.AppHelper;
import com.mobile.masfat.baseactivity.BaseActivity;
import com.mobile.masfat.customwidget.RegularEditText;
import com.mobile.masfat.screens.fragment.facilities.FacilitiesFragment;
import com.mobile.masfat.screens.fragment.listfragment.ListFragment;
import com.mobile.masfat.screens.fragment.parkingbooking.ParkingBookingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapViewFragment extends Fragment implements OnMapReadyCallback {
    @BindView(R.id.txt_destination)
    RegularEditText txtDestination;
    @BindView(R.id.img_list)
    ImageView imgList;
    LatLngBounds.Builder builder;
    CameraUpdate cu;
    private GoogleMap mMap;
    private LatLng[] geoPoints = {new LatLng(25.263056,55.297222),new LatLng(25.3575,55.390833), new LatLng(25.413611,55.445556), new LatLng(25.2328, 55.5081)};
    private String[] locationNames = {"Dubai","Sharjah","Ajman", "Al Khawaneej"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map_view, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((BaseActivity) getActivity()).setHeaderTitle(getString(R.string.get_direction));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        imgList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity baseActivity = (BaseActivity) getActivity();
                baseActivity.replaceFragmentWithStack(new ListFragment(),getString(R.string.list_view_parking));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.clear();
        try {
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(getActivity(), R.raw.map_style));
            if (!success) {
                Log.e("MapView", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapView", "Can't find style. Error: ", e);
        }
        List<Marker> markersList = new ArrayList<Marker>();
        for (int i = 0; i < geoPoints.length; i++) {
            MarkerOptions markerOptions = new MarkerOptions().position(geoPoints[i]).title(locationNames[i]).icon(BitmapDescriptorFactory.fromBitmap(AppHelper.createCustomMarker(getActivity(), R.drawable.ic_pin, locationNames[i])));
            Marker mapMarker = googleMap.addMarker(markerOptions);
            mapMarker.setTag(i);
            markersList.add(mapMarker);

        }
        builder = new LatLngBounds.Builder();
        for (Marker m : markersList) {
            builder.include(m.getPosition());
        }
        int padding = 50;
        LatLngBounds bounds = builder.build();
        cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                mMap.animateCamera(cu);
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                int position = (int) marker.getTag();
                ((BaseActivity) getActivity()).replaceFragmentWithStack(new ParkingBookingFragment(),getString(R.string.parking_booking));
                return false;
            }
        });
    }
}
