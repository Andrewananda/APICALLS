package com.example.andrew.apicallsapp.network;

import com.example.andrew.apicallsapp.models.User;
import com.example.andrew.apicallsapp.models.UserDetails;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("login")
    Call<UserDetails> loginUser(@Query("email") String email, @Query("password") String password);

}
