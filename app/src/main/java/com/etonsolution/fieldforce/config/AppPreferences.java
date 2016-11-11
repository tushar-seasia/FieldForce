package com.etonsolution.fieldforce.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.etonsolution.fieldforce.dtos.UserRegisterDTO;
import com.google.gson.Gson;

/**
 * Created by BawejaTushar on 11/11/2016.
 */

public class AppPreferences {
    private static AppPreferences instance;

    public static AppPreferences init(Context context) {
        if (null == instance) {
            instance = new AppPreferences(context);
        }
        return instance;
    }

    private Context context;
    protected SharedPreferences sharedPreferences;

    public AppPreferences(Context context) {
        super();
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * *      Methods To Set values in Preferences
     **/

    private void setInteger(String key, int val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt(key, val);
        e.commit();
    }

    private void setString(String key, String val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString(key, val);
        e.commit();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void setBoolean(String key, boolean val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putBoolean(key, val);
        e.commit();
    }

    private void setDouble(String key, double val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString(key, String.valueOf(val));
        e.commit();
    }

    private void setLong(String key, long val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putLong(key, val);
        e.commit();
    }

    private void remove(String key) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.remove(key);
        e.commit();
    }

    public void saveData(String key, String value) {
        setString(key, value);
    }

    public String getData(String key) {
        return sharedPreferences.getString(key, null);
    }

    public UserRegisterDTO getUserInfo() {
        UserRegisterDTO userRegisterDTO = null;
        try {
            String value = sharedPreferences.getString("key", null);
            if (null != value) {
                userRegisterDTO = new Gson().fromJson(value, UserRegisterDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRegisterDTO;
    }

    public void setUserInfo(UserRegisterDTO userInfoDTO) {
        if (null != userInfoDTO) {
            setString("key", new Gson().toJson(userInfoDTO));
        } else {
            remove("key");
        }
    }
}
