package com.example.retrofit.Interface;

import com.example.retrofit.Modelo.Albums;
import com.example.retrofit.Modelo.Comments;
import com.example.retrofit.Modelo.Posts;
import com.example.retrofit.Modelo.Users;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceHolderApi {

    @GET("posts") Call<List<Posts>> getPosts();

    @GET("Comments") Call<List<Comments>> getComments();

    @GET("Albums") Call<List<Albums>> getAlbums();

    @GET("Users") Call<List<Users>> getUsers();

}
