package com.etonsolution.fieldforce.api;

import com.etonsolution.fieldforce.R;
import com.etonsolution.fieldforce.config.App;
import com.etonsolution.fieldforce.dtos.UserRegisterDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.internal.http.RetryableSink;

import java.util.Map;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by BawejaTushar on 11/4/2016.
 */

public class APIHelper {
    private static APIHelper instance;
    private APIService apiService;
    private App app;

    public static synchronized APIHelper init(App app){
        if(null == instance){
            instance=new APIHelper();
            instance.setApplication(app);
            instance.initAPIService();
        }
        return instance;
    }

    private void setApplication(App app) {
        this.app=app;
    }

    private void initAPIService() {
        Gson gson=new GsonBuilder().serializeNulls().create();
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://marutifront.16mb.com/android/")
                .build();

        apiService=retrofit.create(APIService.class);
    }

    public void userRegister(UserRegisterDTO userRegisterDTO, final APICallback<Map> callback){
        apiService.userRegister(userRegisterDTO).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Response<Map> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure(app.getResources().getString(R.string.error_server_communication));
            }
        });
    }

    public void userRegisterw(UserRegisterDTO userRegisterDTO, final APICallback<Map> callback){
        apiService.userRegister(userRegisterDTO).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Response<Map> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

}
