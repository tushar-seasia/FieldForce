package com.etonsolution.fieldforce.dtos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by BawejaTushar on 11/9/2016.
 */

public class UserRegisterDTO implements Serializable {
    @SerializedName("latitude")
    private String shopLatitude;
    @SerializedName("longitude")
    private String shopLongitude;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("image")
    private String shopImage;
    @SerializedName("shop_status")
    private String shopStatus;
    @SerializedName("shop_name")
    private String shopName;
    @SerializedName("shop_owner_name")
    private String shopOwnerName;
    @SerializedName("shop_contact_number")
    private String shopContactNumber;
    @SerializedName("shop_address")
    private String shopAddress;
    @SerializedName("state")
    private String state;
    @SerializedName("city")
    private String city;
    @SerializedName("variants")
    private String variant;
    @SerializedName("scheme")
    private String scheme;
    @SerializedName("remark")
    private String remark;
    @SerializedName("give_status")
    private String giveStatus;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String shopLatitude, String shopLongitude, String date, String time, String shopImage, String shopStatus, String shopName, String shopOwnerName, String shopContactNumber, String shopAddress, String state, String city, String variant, String scheme, String remark, String giveStatus) {
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
        this.date = date;
        this.time = time;
        this.shopImage = shopImage;
        this.shopStatus = shopStatus;
        this.shopName = shopName;
        this.shopOwnerName = shopOwnerName;
        this.shopContactNumber = shopContactNumber;
        this.shopAddress = shopAddress;
        this.state = state;
        this.city = city;
        this.variant = variant;
        this.scheme = scheme;
        this.remark = remark;
        this.giveStatus = giveStatus;
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwnerName() {
        return shopOwnerName;
    }

    public void setShopOwnerName(String shopOwnerName) {
        this.shopOwnerName = shopOwnerName;
    }

    public String getShopContactNumber() {
        return shopContactNumber;
    }

    public void setShopContactNumber(String shopContactNumber) {
        this.shopContactNumber = shopContactNumber;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGiveStatus() {
        return giveStatus;
    }

    public void setGiveStatus(String giveStatus) {
        this.giveStatus = giveStatus;
    }
}
