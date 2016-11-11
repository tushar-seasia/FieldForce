package com.etonsolution.fieldforce.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
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
import com.etonsolution.fieldforce.api.APICallback;
import com.etonsolution.fieldforce.config.App;
import com.etonsolution.fieldforce.config.AppPreferences;
import com.etonsolution.fieldforce.dtos.UserRegisterDTO;
import com.etonsolution.fieldforce.utils.StringUtils;
import com.etonsolution.fieldforce.utils.ToastUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopRegisterActivity extends AppCompatActivity {
    @Bind(R.id.spShopStatus)
    Spinner spShopStatus;
    @Bind(R.id.spVariants)
    Spinner spvariants;
    @Bind(R.id.spScheme)
    Spinner spScheme;
    @Bind(R.id.spGiveStatus)
    Spinner spGiveStatus;
    @Bind(R.id.ivUploadPic)
    ImageView ivUploadPic;
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
    private String date, time, shopImage, shopStatus, variant, scheme, giveStatus, shopName, ownerName, ownerContact, shopAddress, state, city, remark, latitude, longitude;

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

    @OnClick(R.id.btnSave)
    public void onClickSave() {
        if (validateFields()) {
            getValuesFromFields();
            UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
            userRegisterDTO.setShopLatitude(latitude);
            userRegisterDTO.setShopLongitude(longitude);
            //userRegisterDTO.setDate(date);
            //userRegisterDTO.setTime(time);
            //userRegisterDTO.setShopImage(shopImage);
            userRegisterDTO.setShopStatus(shopStatus);
            userRegisterDTO.setShopName(shopName);
            userRegisterDTO.setShopOwnerName(ownerName);
            userRegisterDTO.setShopContactNumber(ownerContact);
            userRegisterDTO.setShopAddress(shopAddress);
            userRegisterDTO.setState(state);
            userRegisterDTO.setCity(city);
            userRegisterDTO.setVariant(variant);
            userRegisterDTO.setScheme(scheme);
            userRegisterDTO.setRemark(remark);
            userRegisterDTO.setGiveStatus(giveStatus);

            App.getApiHelper().userRegister(userRegisterDTO, new APICallback<Map>() {
                @Override
                public void onSuccess(Map map) {
                    Gson gson = new Gson();
                    UserRegisterDTO userRegisterDTO1 = gson.fromJson(gson.toJson(map.get("")), UserRegisterDTO.class);
                    App.getAppContext().setUserRegisterDTO(userRegisterDTO1);
                }

                @Override
                public void onFailure(String errorMessage) {

                }

                @Override
                public void onSessionExpire() {

                }
            });
        }
    }

    @OnClick(R.id.btnCancel)
    public void onClickCancel() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setTitle("Dialog");
        //App.getPreferences().getUserInfo().getRemark()
        //alertDialogBuilder.setMessage(App.getPreferences().getUserInfo().getRemark());
        alertDialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(activity, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void getValuesFromFields() {
        shopName = etShopName.getText().toString();
        ownerName = etShopOwnerName.getText().toString();
        ownerContact = etOwnerContactNo.getText().toString();
        shopAddress = etShopAddress.getText().toString();
        state = etState.getText().toString();
        city = etCity.getText().toString();
        remark = etremarks.getText().toString();

        if (getString(R.string.shop_closed).equals(spShopStatus.getSelectedItem())) {
            shopStatus = getResources().getString(R.string.shop_closed);
        } else if (getString(R.string.owner_not_available).equals(spShopStatus.getSelectedItem())) {
            shopStatus = getResources().getString(R.string.owner_not_available);
        } else if (getString(R.string.shop_not_exist).equals(spShopStatus.getSelectedItem())) {
            shopStatus = getResources().getString(R.string.shop_not_exist);
        } else {
            shopStatus = getResources().getString(R.string.shop_open);
        }

        if (getString(R.string.yes).equals(spvariants.getSelectedItem())) {
            variant = getResources().getString(R.string.yes);
        } else if (getString(R.string.no).equals(spvariants.getSelectedItem())) {
            variant = getResources().getString(R.string.no);
        } else if (getString(R.string.na).equals(spvariants.getSelectedItem())) {
            variant = getResources().getString(R.string.na);
        } else {
            variant = getResources().getString(R.string.new_variant);
        }

        if (getString(R.string.yes).equals(spScheme.getSelectedItem())) {
            scheme = getResources().getString(R.string.yes);
        } else if (getString(R.string.no).equals(spScheme.getSelectedItem())) {
            scheme = getResources().getString(R.string.no);
        } else if (getString(R.string.na).equals(spScheme.getSelectedItem())) {
            scheme = getResources().getString(R.string.na);
        } else {
            scheme = getResources().getString(R.string.scheme);
        }

        if (getString(R.string.na).equals(spGiveStatus.getSelectedItem())) {
            giveStatus = getResources().getString(R.string.na);
        } else if (getString(R.string.complaint_open).equals(spGiveStatus.getSelectedItem())) {
            giveStatus = getResources().getString(R.string.complaint_open);
        } else if (getString(R.string.complaint_closed).equals(spGiveStatus.getSelectedItem())) {
            giveStatus = getResources().getString(R.string.complaint_closed);
        } else if (getString(R.string.good_shop).equals(spGiveStatus.getSelectedItem())) {
            giveStatus = getResources().getString(R.string.good_shop);
        } else {
            giveStatus = getResources().getString(R.string.give_status);
        }
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
        if (location == null) {
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        latitude = String.valueOf(lat);
        longitude = String.valueOf(lng);
        tvLat.setText(String.valueOf(lat));
        tvLng.setText(String.valueOf(lng));
        Toast.makeText(getApplicationContext(), lat + " " + lng, Toast.LENGTH_LONG).show();
        Log.v("lat lng", lat + " " + lng);
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

    public boolean validateFields() {
        if (StringUtils.isEmpty(etShopName.getText().toString())) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_name));
            return false;
        }

        if (StringUtils.isEmpty(etShopOwnerName.getText().toString())) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_owner_name));
            return false;
        }

        if (StringUtils.isEmpty(etOwnerContactNo.getText().toString()) && etOwnerContactNo.getText().toString().length() < 10) {
            ToastUtils.showToast(activity, getResources().getString(R.string.length_mobile));
            return false;
        }

        if (StringUtils.isEmpty(etShopAddress.getText().toString())) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_address));
            return false;
        }

        if (StringUtils.isEmpty(etState.getText().toString())) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_state));
            return false;
        }

        if (StringUtils.isEmpty(etCity.getText().toString())) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_city));
            return false;
        }

        if (0 == spvariants.getSelectedItemPosition()) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_variant));
            return false;
        }

        if (0 == spScheme.getSelectedItemPosition()) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_scheme));
            return false;
        }

        if (0 == spGiveStatus.getSelectedItemPosition()) {
            ToastUtils.showToast(activity, getResources().getString(R.string.empty_shop_status));
            return false;
        }
        return true;
    }
}
