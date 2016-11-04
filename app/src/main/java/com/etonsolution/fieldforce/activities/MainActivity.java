package com.etonsolution.fieldforce.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.etonsolution.fieldforce.R;
import com.etonsolution.fieldforce.adapter.SpinnerAdapter;
import com.etonsolution.fieldforce.utils.StringUtils;
import com.etonsolution.fieldforce.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.spShopStatus)
    Spinner spShopStatus;
    @Bind(R.id.spVariants)
    Spinner spvariants;
    @Bind(R.id.spScheme)
    Spinner spScheme;
    @Bind(R.id.spGiveStatus)
    Spinner spGiveStatus;
    @Bind(R.id.ivUploadPic)
    ImageView ivUploadImage;
    @Bind(R.id.etShopName)
    EditText etShopName;
    @Bind(R.id.etOwnerName)
    EditText etShopOwnerName;
    @Bind(R.id.etContactNumber)
    EditText etOwnerContactNo;
    @Bind(R.id.etAddress)
    EditText etShopAddress;
    @Bind(R.id.etState)
    EditText etState;
    @Bind(R.id.etCity)
    EditText etCity;
    @Bind(R.id.etRemarks)
    EditText etremarks;
    @Bind(R.id.tvLat)
    TextView tvLat;
    @Bind(R.id.tvLng)
    TextView tvLng;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        ButterKnife.bind(this);
        initShopStatus();
        initVariants();
        initScheme();
        initGiveStatus();
        getLatLng();
    }

    private void getLatLng() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(location==null){
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        double lat=location.getLatitude();
        double lng=location.getLongitude();
        tvLat.setText(String.valueOf(lat));
        tvLng.setText(String.valueOf(lng));
        Toast.makeText(getApplicationContext(), lat+" "+lng, Toast.LENGTH_LONG).show();
        Log.v("lat lng", lat+" "+lng);
    }

    private void initShopStatus() {
        List<String> list = new ArrayList<>();
        list.add("Shop Open");
        list.add("Shop Closed");
        list.add("Owner Not Availabe");
        list.add("Shop Not Exist");
        spShopStatus.setAdapter(new SpinnerAdapter(activity, list));
        spShopStatus.setPopupBackgroundResource(R.drawable.background_spinner_popup);
    }

    private void initVariants() {
        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.new_variant));
        list.add(getResources().getString(R.string.yes));
        list.add(getResources().getString(R.string.no));
        list.add(getResources().getString(R.string.na));
        spvariants.setAdapter(new SpinnerAdapter(activity, list));
        spvariants.setPopupBackgroundResource(R.drawable.background_spinner_popup);
    }

    private void initScheme() {
        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.scheme));
        list.add(getResources().getString(R.string.yes));
        list.add(getResources().getString(R.string.no));
        list.add(getResources().getString(R.string.na));
        spScheme.setAdapter(new SpinnerAdapter(activity, list));
        spScheme.setPopupBackgroundResource(R.drawable.background_spinner_popup);
    }

    private void initGiveStatus() {
        List<String> list = new ArrayList<>();
        list.add(getResources().getString(R.string.give_status));
        list.add(getResources().getString(R.string.na));
        list.add(getResources().getString(R.string.complaint_open));
        list.add(getResources().getString(R.string.complaint_closed));
        list.add(getResources().getString(R.string.good_shop));
        spGiveStatus.setAdapter(new SpinnerAdapter(activity, list));
        spGiveStatus.setPopupBackgroundResource(R.drawable.background_spinner_popup);
    }

    public void validateFields(){
        if(StringUtils.isEmpty(etShopName.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_name));
        }

        if(StringUtils.isEmpty(etShopOwnerName.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_owner_name));
        }

        if(StringUtils.isEmpty(etOwnerContactNo.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_contact_number));
        }

        if(StringUtils.isEmpty(etShopAddress.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_address));
        }

        if(StringUtils.isEmpty(etState.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_state));
        }

        if(StringUtils.isEmpty(etCity.getText().toString())){
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_city));
        }
    }
}
