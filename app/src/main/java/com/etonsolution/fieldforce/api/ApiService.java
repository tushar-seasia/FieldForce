package com.etonsolution.fieldforce.api;

import com.etonsolution.fieldforce.dtos.UserRegisterDTO;

import java.util.Map;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by BawejaTushar on 11/4/2016.
 */

public interface APIService {
    @POST("requestshopinfo.php")
    Call<Map> userRegister(@Body UserRegisterDTO userRegisterDTO);
}
