package com.example.navigationdrawer.web;


import com.example.navigationdrawer.entities.User;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface LoginController {
    @POST("/login")
    Call<User> login(@Query("username") String user, @Query("password") String pwd);


    @POST("logout")
    void logout();
}
