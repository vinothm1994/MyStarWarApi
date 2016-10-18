package com.example.vinoth.mystarwarapi;

/**
 * Created by vinoth on 17/10/16.
 */

import com.example.vinoth.mystarwarapi.model.AllStarShip;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface  ApiInterface {

    @GET("starships")
    Call<AllStarShip> getAllStarship(@Query("page") String page);




}
