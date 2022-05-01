package com.example.retrofit.Interface;

import com.example.retrofit.Modelo.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceHolderApi {

    @GET("posts")
    Call<List<Posts>> getPosts();

}
