package com.etonsolution.fieldforce.config;

import android.support.multidex.MultiDexApplication;

import com.etonsolution.fieldforce.api.APIHelper;
import com.etonsolution.fieldforce.dtos.UserRegisterDTO;

/**
 * Created by BawejaTushar on 11/9/2016.
 */

public class App extends MultiDexApplication {
    private static AppPreferences preferences;
    private static APIHelper apiHelper;
    private static App instance;

    private UserRegisterDTO userRegisterDTO;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        apiHelper = apiHelper.init(instance);
        preferences=AppPreferences.init(instance);

        userRegisterDTO=preferences.getUserInfo();
    }

    public static App getAppContext() {
        return instance;
    }

    public static synchronized APIHelper getApiHelper() {
        return apiHelper;
    }

    public static synchronized AppPreferences getPreferences() {
        return preferences;
    }

    public UserRegisterDTO getUserRegisterDTO() {
        return userRegisterDTO;
    }

    public void setUserRegisterDTO(UserRegisterDTO userRegisterDTO) {
        this.userRegisterDTO = userRegisterDTO;
        preferences.setUserInfo(userRegisterDTO);
    }
}
