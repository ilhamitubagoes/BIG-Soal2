package com.ilhambagoest.soal2.data.api;

import com.ilhambagoest.soal2.data.entity.DataUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestService {

    @POST("/verify")
    Call<DataUser> loginUser(@Query("number_phone") String numberPhone);

    @GET("/profile")
    Call<DataUser> getProfile(@Query("idUser") Integer idUser);

}