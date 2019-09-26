package com.example.plazagenius.networking;

import com.example.plazagenius.models.PostResponse;
import com.example.plazagenius.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlazaService {

    @GET("users")
    Call<UserResponse> getUsers(@Query("per_page") int perPage);

    @POST("/api/users")
    Call<PostResponse> createPost(@Body PostResponse postResponse);
}
