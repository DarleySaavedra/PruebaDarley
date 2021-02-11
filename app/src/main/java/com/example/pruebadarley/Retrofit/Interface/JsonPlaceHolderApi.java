package com.example.pruebadarley.Retrofit.Interface;

import com.example.pruebadarley.Retrofit.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Posts>>getPosts();

}
