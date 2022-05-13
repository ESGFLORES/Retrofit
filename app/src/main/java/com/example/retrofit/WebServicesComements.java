package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import com.example.retrofit.Interface.JsonplaceHolderApi;
import com.example.retrofit.Modelo.Comments;
import com.example.retrofit.Modelo.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServicesComements extends AppCompatActivity {


    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services_comements);

        mJsonTxtView = findViewById(R.id.jsonTextComment);
        getComments();
    }

    private void getComments(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonplaceHolderApi jsonplaceHolderApi = retrofit.create(JsonplaceHolderApi.class);

        Call<List<Comments>> call = jsonplaceHolderApi.getComments();

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()){
                    mJsonTxtView.setText("codigo: "+response.code());
                    return;
                }
                List<Comments> CommentsList = response.body();
                for (Comments comments:CommentsList){
                    String content ="";
                    content +="postId:"+ comments.getPostIdComm() + "\n";
                    content +="id:"+ comments.getIdComm() + "\n";
                    content +="name:"+ comments.getNameComm() + "\n";
                    content +="email:"+ comments.getEmailComm() + "\n";
                    content +="body:"+ comments.getBodyComm() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });




    }



}

