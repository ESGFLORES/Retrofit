package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.Interface.JsonplaceHolderApi;
import com.example.retrofit.Modelo.Albums;
import com.example.retrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServicesAlbums extends AppCompatActivity {
    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services_albums);
        mJsonTxtView = findViewById(R.id.jsonTexAlbum);
        getAlbums();
    }

    public void getAlbums() {
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonplaceHolderApi jsonplaceHolderApi = retrofit.create(JsonplaceHolderApi.class);

        Call<List<Albums>> call= jsonplaceHolderApi.getAlbums();

        call.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response){

                if (!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }

                List<Albums> AlbumsList = response.body();

                for(Albums albums: AlbumsList){
                    String content ="";
                    content +="userId:"+ albums.getUserIdAlb() + "\n";
                    content +="id:"+ albums.getIdAlb() + "\n";
                    content +="title:"+ albums.getTitleAlb() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}